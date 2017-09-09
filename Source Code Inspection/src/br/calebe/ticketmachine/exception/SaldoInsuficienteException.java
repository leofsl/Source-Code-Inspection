package br.calebe.ticketmachine.exception;

/**
 *
 * @author Leonardo Ferreira Silveira Lima
 */
public class SaldoInsuficienteException extends Exception {

    //Adicionando mensagem de ERRO.
    public SaldoInsuficienteException() {
        super("Saldo Insuficiente");
    }
}
