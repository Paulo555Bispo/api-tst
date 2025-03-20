package com.pb.apitst.domain.endereco;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CadatrarDadosEndereco(
        TipoLogradouro tipoLogradouro,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        TipoUF uf,
        String cep
) {
}
