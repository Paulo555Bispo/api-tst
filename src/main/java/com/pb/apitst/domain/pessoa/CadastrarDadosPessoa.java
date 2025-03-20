package com.pb.apitst.domain.pessoa;

import com.pb.apitst.domain.endereco.CadatrarDadosEndereco;
import com.pb.apitst.domain.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CadastrarDadosPessoa<enderecos>(
        @NotBlank String nome,
        boolean ativo
        List<Endereco>enderecos;
        ) {
}
// TODO: Resolver a identificação no cadastro de vários endereços, para a mesma Pessoa.