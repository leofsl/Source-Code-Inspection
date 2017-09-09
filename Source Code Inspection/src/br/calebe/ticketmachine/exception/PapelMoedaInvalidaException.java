package br.calebe.ticketmachine.exception;

/**
 *
 * @author Leonardo Ferreira Silveira Lima
 */
public class PapelMoedaInvalidaException extends Exception {

    //Adicionando mensagem de ERRO.
    public PapelMoedaInvalidaException() {
        super("Papel Moeda Inválido");
    }
}
