package com.gerenciamento_escolar.api.entity.model.escola;

public record DadosListagemEscola(
    Long id,
    String nome,
    String email

) {
    public DadosListagemEscola(Escola escola) {
        this(
            escola.getId(),
            escola.getNome(),
            escola.getEmail()
        );
    }
}
