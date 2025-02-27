package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data // abstrai os getters e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os atributos
@Entity // anota a classe como uma entidade do JPA indicando que Aluno será uma tabela
@Table(name = "tb_alunos") // nome da tabela
public class Aluno {

  @Id // anota o atributo como uma chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // anota o atributo como uma chave primária auto-incremental no banco
  private Long id;

  private String nome;

  @Column(unique = true) // indica que o campo deve ser unico no banco
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  // Define um relacionamento OneToMany entre Aluno e AvaliacaoFisica, onde o mapeamento é controlado pela propriedade "aluno" em AvaliacaoFisica.
// CascadeType.REMOVE garante que ao remover um Aluno, todas as suas AvaliacoesFisicas associadas também serão removidas.
// FetchType.LAZY carrega as AvaliacoesFisicas apenas quando explicitamente acessadas, otimizando o desempenho.
  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
  @JsonIgnore
// ignora a propriedade "avaliacoes" na serialização JSON para evitar o loop infinito entre Aluno e AvaliacaoFisica caso houver uma AvaliacaoFisica associada ao Aluno.
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
