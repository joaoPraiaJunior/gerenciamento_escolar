package com.gerenciamento_escolar.api.entity.model.disciplina;

import com.gerenciamento_escolar.api.entity.model.professor.AulaDisciplina;

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

@Table(name = "disciplina")
@Entity(name = "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    AulaDisciplina disciplina;

    private int carga_horaria;

    private boolean ativo;

    public Disciplina(DadosCadastroDisciplina dados) {
        this.ativo = true;
        this.disciplina = dados.disciplina();
        this.carga_horaria = dados.carga_horaria();
    }

    public void atualizar(DadosAtualizaDisciplina dados) {
        if(dados.disciplina() != null) {
            this.disciplina = dados.disciplina();
        }
        if(dados.carga_horaria() != 0) {
            this.carga_horaria = dados.carga_horaria();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
