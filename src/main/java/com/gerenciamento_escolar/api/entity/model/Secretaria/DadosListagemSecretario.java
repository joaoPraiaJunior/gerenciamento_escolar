package com.gerenciamento_escolar.api.entity.model.secretaria;

public record DadosListagemSecretario(
        Long id,
        String nome,
        CargoSecretario cargo_secretario) {

    public DadosListagemSecretario(Secretario secretario) {
        this(secretario.getId(), secretario.getNome(), secretario.getCargo_secretario());
    }

}