package com.gerenciamento_escolar.api.entity.model.pessoa;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private String nome_mae;
    private String nome_pai;
    private LocalDate data_nascimento;
    private String nacionalidade;
    private String naturalidade;
    private String genero;
    private String estado_civil;
    private String cpf;
    private String rg;
    private String orgao_emissor;
    private LocalDate data_emissao;
    private String email;
    private String telefone;

    public Pessoa(DadosPessoa dados) {
        this.nome_mae = dados.nome_mae();
        this.nome_pai = dados.nome_pai();
        this.data_nascimento = dados.data_nascimento();
        this.nacionalidade = dados.nacionalidade();
        this.naturalidade = dados.naturalidade();
        this.genero = dados.genero();
        this.estado_civil = dados.estado_civil();
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.orgao_emissor = dados.orgao_emissor();
        this.data_emissao = dados.data_emissao();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizarInformacoesPessoa(DadosPessoa dados) {
        if(dados.nome_mae() != null) {
            this.nome_mae = dados.nome_mae();
        }

        if(dados.nome_pai() != null) {
            this.nome_pai = dados.nome_pai();
        }

        if(dados.data_nascimento() != null) {
            this.data_nascimento = dados.data_nascimento();
        }

        if(dados.nacionalidade() != null) {
            this.nacionalidade = dados.nacionalidade();
        }

        if(dados.naturalidade() != null) {
            this.naturalidade = dados.naturalidade();
        }

        if(dados.genero() != null) {
            this.genero = dados.genero();
        }

        if(dados.estado_civil() != null) {
            this.estado_civil = dados.estado_civil();
        }

        if(dados.cpf() != null) {
            this.cpf = dados.cpf();
        }

        if(dados.rg() != null) {
            this.rg = dados.rg();
        }

        if(dados.orgao_emissor() != null) {
            this.orgao_emissor = dados.orgao_emissor();
        }

        if(dados.data_emissao() != null) {
            this.data_emissao = dados.data_emissao();
        }

        if(dados.email() != null) {
            this.email = dados.email();
        }

        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }
}
