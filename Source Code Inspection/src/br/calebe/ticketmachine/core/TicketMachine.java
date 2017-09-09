package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Leonardo Ferreira Silveira Lima
 */
public class TicketMachine {

    //Os atributos passam a ser private.
    private int precoDoBilhete;
    private int saldo;
    private int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.precoDoBilhete = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            //Percorre o vetor corretamente, acessando as outras posições. 
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
            if (!achou) { //Com isso, a exceção é lançada toda vez que uma nota invalida é inserida.
                throw new PapelMoedaInvalidaException();
            }
            this.saldo += quantia;
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<PapelMoeda> getTroco() {
        //Funcão Implementada.
        Troco troco = new Troco(saldo);
        return troco.getIterator();
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < precoDoBilhete) {
            throw new SaldoInsuficienteException();
        }
        saldo -= precoDoBilhete; //Saldo atualizado com o débito.
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
