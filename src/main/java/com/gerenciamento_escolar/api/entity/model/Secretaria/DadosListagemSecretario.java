package com.gerenciamento_escolar.api.entity.model.Secretaria;

public record DadosListagemSecretario(
        Long id,
        String nome,
        CargoSecretario cargoSecretario) {

    public DadosListagemSecretario(Secretario secretario) {
        this(secretario.getId(), secretario.getNome(), secretario.getCargoSecretario());
    }

}