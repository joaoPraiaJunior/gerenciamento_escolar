package com.gerenciamento_escolar.api.service;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoMatricula(
    @NotNull
    Long id_matricula,

    @NotNull
    MotivoCancelamentoMatricula motivo)
{
    
}
