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
@Table(name = "tb_avaliacoes") // nome da tabela
public class AvaliacaoFisica {

  @Id // anota o atributo como uma chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // anota o atributo como uma chave primária auto-incremental no banco
  private Long id;

  @ManyToOne // relacionamento de banco de dados muitos-para-um com Aluno e AvaliacaoFisica (muitas avaliações podem ter 1 aluno)
  @JoinColumn(name = "aluno_id") // indica a coluna FOREIGN KEY do relacionamento muitos-para-um com Aluno e AvaliacaoFisica
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column (name = "peso_atual")
  private double peso;

  @Column (name = "altura_atual")
  private double altura;

}
