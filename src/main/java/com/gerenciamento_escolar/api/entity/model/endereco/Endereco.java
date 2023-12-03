package com.gerenciamento_escolar.api.entity.model.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.estado = dados.estado();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoesEndereco(DadosEndereco dados) {
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }

        if(dados.bairro() != null) {
            this.bairro = dados.bairro();
        }

        if(dados.cep() != null) {
            this.cep = dados.cep();
        }

        if(dados.estado() != null) {
            this.estado = dados.estado();
        }

        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }

        if(dados.numero() != null) {
            this.numero = dados.numero();
        }

        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }

}

