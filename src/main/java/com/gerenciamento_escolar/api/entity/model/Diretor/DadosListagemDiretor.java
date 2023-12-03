package com.gerenciamento_escolar.api.entity.model.Diretor;

public record DadosListagemDiretor(
    Long id,
    String nome,
    CargoDiretoria cargoDiretoria
) {

    public DadosListagemDiretor(Diretor diretor) {
        this(diretor.getId(), diretor.getNome(), diretor.getCargoDiretoria());
    }

}
