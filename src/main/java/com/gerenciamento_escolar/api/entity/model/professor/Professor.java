package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "professor")
@Entity(name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String graduacao;
    private String instituicao_formacao;

    private LocalDate data_formacao;

    private boolean licenciatura;
    private String especializacao;
    private String mestrado;
    private String doutorado;

    @Embedded
    private Pessoa pessoa;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private AulaDisciplina aula_disciplina;

    public Professor(DadosCadastroProfessor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.graduacao = dados.graduacao();
        this.instituicao_formacao = dados.instituicao_formacao();
        this.data_formacao = dados.data_formacao();
        this.licenciatura = dados.licenciatura();
        this.especializacao = dados.especializacao();
        this.mestrado = dados.mestrado();
        this.doutorado = dados.doutorado();
        this.aula_disciplina = dados.aula_disciplina();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaProfessor dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.graduacao() != null) {
            this.graduacao = dados.graduacao();
        }
        if (dados.instituicao_formacao() != null) {
            this.instituicao_formacao = dados.instituicao_formacao();
        }
        if (dados.data_formacao() != null) {
            this.data_formacao = dados.data_formacao();
        }
        if (dados.licenciatura() == false || dados.licenciatura() == true) {
            this.licenciatura = dados.licenciatura();
        }
        if (dados.especializacao() != null) {
            this.especializacao = dados.especializacao();
        }
        if (dados.mestrado() != null) {
            this.mestrado = dados.mestrado();
        }
        if(dados.doutorado() != null) {
            this.doutorado = dados.doutorado();
        }
        if(dados.aula_disciplina() != null) {
            this.aula_disciplina = dados.aula_disciplina();
        }
        if(dados.pessoa() != null) {
            this.pessoa.atualizarInformacoesPessoa(dados.pessoa());
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
