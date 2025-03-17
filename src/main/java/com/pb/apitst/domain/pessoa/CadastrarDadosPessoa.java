package com.pb.apitst.domain.pessoa;

import jakarta.validation.constraints.NotBlank;

public record CadastrarDadosPessoa(
        @NotBlank String nome,
        boolean ativo
        //List<Endereco> enderecos;
        ) {
}
