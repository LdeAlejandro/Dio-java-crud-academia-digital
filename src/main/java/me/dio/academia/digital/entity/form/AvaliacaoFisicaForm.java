package me.dio.academia.digital.entity.form;

//import me.dio.academia.digital.entity.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // abstrai os getters e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os atributos
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;
}
