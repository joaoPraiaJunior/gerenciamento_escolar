package com.gerenciamento_escolar.api.entity.model.rh;

public record DadosListagemRH(
        Long id,
        String nome,
        CargoRH cargo_rh) {

    public DadosListagemRH(RH rh) {
        this(rh.getId(), rh.getNome(), rh.getCargo_rh());
    }

}
