package com.pb.apitst.infra.exception;

public class ValidacaoException extends RuntimeException{
    private static final long serialVersionUID = 1l;
    public ValidacaoException(String mensagem) {
        super(mensagem);

    }
}
