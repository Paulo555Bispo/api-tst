package com.pb.apitst.controller;

import com.pb.apitst.domain.pessoa.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired /*Injeção de dependencia*/
    private RepositoryPessoa repository; /*Interface para conexão com o banco de dados.*/

    @PostMapping
    @Transactional  /*Só é necessário informar, quando realizar uma transação com o BD.*/
    public ResponseEntity cadastrar(@RequestBody @Valid CadastrarDadosPessoa dados, UriComponentsBuilder uriComponentsBuilder) {
        var pessoa = new Pessoa(dados); /*É necessário usar um construtor para converter os dados (JSON), no formato JPA.*/
        repository.save(pessoa);

        var uri = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoDadosPessoa(pessoa));

        /* O CONTROLER recebe um objeto DTO. Então se faz necessário a conversão de um DTO para
         *  um objeto/entidade JPA. Para facilitar e evitar ter que informar todos os campos da classe Pessoa,
         *  devemos criar um construtor na classe Pessoa. */
    }

    @GetMapping
    public ResponseEntity<Page<ListagemDadosPessoa>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemDadosPessoa::new);
        return ResponseEntity.ok((Page<ListagemDadosPessoa>) page);

        /* Você precisará passar parâmetros na URL, indicando quantos registros irá colocar em cada página,
        qual a ordem que deseja apresentar a listagem, etc.
        Você poderá também, passar estar informações dentro do CONTROLLER, através de uma anotação
        @PageableDefault(size = 10, sort = {"nome"})
        Resumindo: Você poderá passar os parâmetros na API, mas prevalecerá o que for passado na URL. */
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoDadosPessoa(pessoa));
    }

    @PutMapping("/{id}")
    @Transactional  //É usado quando houver uma transação com o BD
    public ResponseEntity atualizar(@RequestBody @NotNull @Valid AtualizarDadosPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id()); //O Repository é usado para acessar o Banco de Dados
        pessoa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhamentoDadosPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        pessoa.desativar();
        return ResponseEntity.noContent().build();
    }
}
