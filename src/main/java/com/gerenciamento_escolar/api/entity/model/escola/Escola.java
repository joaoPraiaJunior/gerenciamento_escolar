package com.gerenciamento_escolar.api.entity.model.escola;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "escola")
@Entity(name = "Escola")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String instagram;
    private String youtube;
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    public Escola(DadosCadastroEscola dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.instagram = dados.instagram();
        this.youtube = dados.youtube();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaEscola dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.instagram() != null) {
            this.instagram = dados.instagram();
        }
        if (dados.youtube() != null) {
            this.youtube = dados.youtube();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}