package com.pb.apitst.domain.pessoa;

import com.pb.apitst.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    @Size(max = 60, min = 3)
    private String nome;

/*
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;
    */

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;
    @Column(nullable = false)
    private boolean ativo;

    /*Construtor padrão*/
    public Pessoa() {

    }

    /*Construtor criado para pegar os dados (DTO-JSON)*/
    public Pessoa(CadastrarDadosPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();

        //this.endereco = new Endereco(dados.endereco());
    }

    /*Construtor criado para pegar os dados (DTO-JSON)*/
    public void atualizarInformacoes(AtualizarDadosPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

/*        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }*/
    }

    public void desativar() {
        this.ativo = false;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    // EqualsAndHashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return ativo == pessoa.ativo && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ativo);
    }
}