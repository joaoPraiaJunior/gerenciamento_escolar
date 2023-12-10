package com.gerenciamento_escolar.api.service.validations;

public class ValidacaoException extends RuntimeException {
    
    public ValidacaoException(String messagem) {
        super(messagem);
    }
}
