package com.pb.apitst.domain.endereco;

import com.pb.apitst.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private TipoUF uf;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    /*Construtor criado para pegar os dados (DTO-JSON)*/
    public Endereco(DadosEndereco dados) {
        this.tipoLogradouro = TipoLogradouro.valueOf(dados.descricao());
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = TipoUF.valueOf(dados.uf());
        this.cep = dados.cep();
    }

    /*Construtor criado para atualizar endereço (DTO-JSON)*/
    public void atualizarEndereco(DadosEndereco dados) {
        if (dados.descricao() != null) {
            this.tipoLogradouro = TipoLogradouro.valueOf(dados.descricao());
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            this.uf = TipoUF.valueOf(dados.uf());
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }
}