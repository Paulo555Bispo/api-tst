package com.pb.apitst.domain.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryPessoa extends JpaRepository<Pessoa, Long> {

    Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);

    //Sintaxe JPQL (Java Persistence Query Language)
/*    @Query("""
            select p.ativo
            from Pessoa p
            where
            p.id = :idPessoa
            """)
    Boolean findAtivoById(Long idPessoa);*/
}
