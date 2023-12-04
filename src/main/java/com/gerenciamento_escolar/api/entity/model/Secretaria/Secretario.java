package com.gerenciamento_escolar.api.entity.model.secretaria;

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

@Table(name = "secretario")
@Entity(name = "Secretario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Secretario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Pessoa pessoa;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private CargoSecretario cargo_secretario;

    private boolean ativo;

        public Secretario(DadosCadastroSecretario dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cargo_secretario = dados.cargo_secretario();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

        public void atualizar(DadosAtualizaSecretario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cargo_secretario() != null) {
            this.cargo_secretario = dados.cargo_secretario();
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
