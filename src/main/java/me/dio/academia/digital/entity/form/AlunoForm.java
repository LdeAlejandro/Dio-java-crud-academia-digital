package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data // abstrai os getters e setters
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os atributos
public class AlunoForm {


@NotEmpty(message = "O campo nome deve ser preenchido")
@Size (min = 3, max = 50, message = "'${validatedValue}' O campo nome deve ter entre {min} e {max} caracteres")
  private String nome;

  @NotEmpty(message = "O campo CPF deve ser preenchido")
  @CPF(message = "'${validatedValue}' CPF inválido")
  private String cpf;

  @NotEmpty(message = "O campo bairro deve ser preenchido")
  @Size (min = 3, max = 50, message = "'${validatedValue}' O campo bairro deve ter entre {min} e {max} caracteres")
  private String bairro;

  @NotNull (message = "O campo Data deve ser preenchido")
  @Past (message = "'${validatedValue}' Data de nascimento inválida")
  private LocalDate dataDeNascimento;
}
