package com.pb.apitst.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank String descricao,
        @NotBlank String logradouro,
        @NotBlank String numero,
                  String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String uf,
        @NotBlank @Pattern(regexp = "\\d{8}") String cep
        ) {
}

