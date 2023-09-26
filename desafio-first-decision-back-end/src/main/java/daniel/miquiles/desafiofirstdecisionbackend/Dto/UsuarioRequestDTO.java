package daniel.miquiles.desafiofirstdecisionbackend.Dto;

import org.hibernate.validator.constraints.Length;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    @NotBlank(message = "O nome não pode ser nulo")
    @Length(min = 3, max = 50, message = "O nome deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(length = 51, nullable = false)
    private String nome;
    
    @NotBlank(message = "O email não pode ser nulo")
    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "A senha não pode ser nula")
    @Length(min = 6, max = 20, message = "A senha deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(length = 51, nullable = false)
    private String senha;

    @NotBlank(message = "A confirmação não pode ser nula")
    @Length(min = 6, max = 20, message = "O nome deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(length = 51, nullable = false)
    private String confirmacao;

    public Usuario transformaParaObjeto(){
        return new Usuario(nome, email, senha);
    }


}
