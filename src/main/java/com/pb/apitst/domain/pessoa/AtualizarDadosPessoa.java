package com.pb.apitst.domain.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarDadosPessoa( @NotNull Long id, @NotBlank String nome) {
}