package com.gerenciamento_escolar.api.entity.model.escola;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

public record DadosDetalhamentoEscola(
    Long id,
    String nome,
    String cnpj,
    String email,
    String telefone,
    String instagram,
    String youtube,
    Endereco endereco
) {

    public DadosDetalhamentoEscola(Escola escola) {
        this(
            escola.getId(),
            escola.getNome(),
            escola.getCnpj(),
            escola.getEmail(),
            escola.getTelefone(),
            escola.getInstagram(),
            escola.getYoutube(),
            escola.getEndereco()
        );
    }
    
}
