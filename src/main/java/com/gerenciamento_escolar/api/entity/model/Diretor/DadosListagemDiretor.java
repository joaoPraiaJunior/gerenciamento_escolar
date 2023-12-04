package com.gerenciamento_escolar.api.entity.model.diretor;

public record DadosListagemDiretor(
    Long id,
    String nome,
    CargoDiretoria cargo_diretoria
) {

    public DadosListagemDiretor(Diretor diretor) {
        this(diretor.getId(), diretor.getNome(), diretor.getCargo_diretoria());
    }

}
