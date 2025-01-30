package me.dio.academia.digital.repository;


import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

/**    O Spring Data JPA permite que você crie métodos de consulta no repositório apenas nomeando-os de forma específica, e o Spring gerará automaticamente as consultas SQL baseadas nos nomes desses métodos. No seu caso, o método findByDataDeNascimento será traduzido pelo Spring para uma consulta que busca os alunos com a data de nascimento igual à fornecida.
 *    O que acontece por trás do findByDataDeNascimento?
 *     Quando você define o metodo findByDataDeNascimento(LocalDate dataDeNascimento), o Spring Data JPA cria automaticamente uma consulta SQL equivalente ao seguinte:
 *     SELECT * FROM aluno WHERE data_de_nascimento = ?;
 *     findBy: Indica que você está buscando uma entidade (Aluno).
 *     DataDeNascimento: Indica o campo na tabela Aluno com o nome data_de_nascimento.
 *    O Spring Data JPA então gera a implementação da consulta para você sem precisar escrever SQL ou JPQL manualmente.
 */
 List <Aluno> findByDataDeNascimento(LocalDate dataDeNascimento );
}
