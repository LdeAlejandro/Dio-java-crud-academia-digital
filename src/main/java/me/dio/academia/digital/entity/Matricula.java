package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // abstrai os getters e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os atributos
@Entity // anota a classe como uma entidade do JPA indicando queserá uma tabela
@Table(name = "tb_matriculas") // nome da tabela
public class Matricula {

  @Id // anota o atributo como uma chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // anota o atributo como uma chave primária auto-incremental no banco
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) // relacionamento de banco de dados muitos-para-um com Aluno e Matricula (muitas matriculas podem ter 1 aluno) caso o aluno seja excluido, as matriculas também serão excluidas
  @JoinColumn(name = "aluno_id") // indica a coluna FOREIGN KEY do relacionamento muitos-para-um com Aluno e Matricula
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
