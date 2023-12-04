package com.gerenciamento_escolar.api.entity.model.aluno;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

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

@Table(name = "aluno")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Pessoa pessoa;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Aluno(DadosCadastroAluno dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaAluno dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.pessoa() != null) {
            this.pessoa.atualizarInformacoesPessoa(dados.pessoa());
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
