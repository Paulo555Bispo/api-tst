package com.pb.apitst.domain.pessoa;

public record DetalhamentoDadosPessoa(Long id,
                                      String nome,
                                      boolean ativo

) {

    /*Construtor*/
    public DetalhamentoDadosPessoa(Pessoa pessoa) {
        this( pessoa.getId(), pessoa.getNome(), pessoa.isAtivo() );
    }
}
