package br.com.auto.exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String mensagem) {
        super(mensagem);
    }
}