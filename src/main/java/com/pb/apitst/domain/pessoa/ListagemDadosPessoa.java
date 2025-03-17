package com.pb.apitst.domain.pessoa;

public record ListagemDadosPessoa(Long id, String nome, boolean ativo) {

    /*Construtor*/
    public ListagemDadosPessoa(Pessoa pessoa) {
        this( pessoa.getId(), pessoa.getNome(), pessoa.isAtivo() );
    }
}
