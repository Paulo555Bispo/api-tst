package com.pb.apitst.domain.usuario;

import com.pb.apitst.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank @Column(nullable = false, unique = true) @Size(max = 40, min = 3)
        private String login;
        @Email
        @NotBlank @Size(max = 100)
        private Pessoa email;
        @NotBlank @Size(min = 4)
        private String pwd;
        private Long pessoa_id;
        private String usuario;
        private String senha;
        private int id_grupo;
        private String password;
        private int id_fornecedor;
}
