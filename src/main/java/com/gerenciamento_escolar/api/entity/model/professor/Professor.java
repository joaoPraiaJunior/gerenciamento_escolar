package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

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
    private AulaDisciplina aulaDisciplina;

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
        this.aulaDisciplina = dados.aulaDisciplina();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaProfessor dados) {
        this.nome = dados.nome();
        this.graduacao = dados.graduacao();
        this.instituicao_formacao = dados.instituicao_formacao();
        this.data_formacao = dados.data_formacao();
        this.licenciatura = dados.licenciatura();
        this.especializacao = dados.especializacao();
        this.mestrado = dados.mestrado();
        this.doutorado = dados.doutorado();
        this.aulaDisciplina = dados.aulaDisciplina();
        this.pessoa.atualizarInformacoesPessoa(dados.pessoa());
        this.endereco.atualizarInformacoesEndereco(dados.endereco());
    }

    public void inativar() {
        this.ativo = false;
    }
}
