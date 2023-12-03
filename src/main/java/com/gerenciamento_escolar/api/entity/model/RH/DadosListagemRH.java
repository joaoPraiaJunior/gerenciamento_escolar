package com.gerenciamento_escolar.api.entity.model.RH;

public record DadosListagemRH(
        Long id,
        String nome,
        CargoRH cargoRH) {

    public DadosListagemRH(RH rh) {
        this(rh.getId(), rh.getNome(), rh.getCargoRH());
    }

}
