package br.com.auto.exception;

public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(String mensagem) {
        super(mensagem);
    }
}