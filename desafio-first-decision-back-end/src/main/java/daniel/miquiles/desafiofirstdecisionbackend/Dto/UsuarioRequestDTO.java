package daniel.miquiles.desafiofirstdecisionbackend.Dto;

import org.hibernate.validator.constraints.Length;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UsuarioRequestDTO {
    @NotBlank(message = "{nome.not.blank}")
    @Length(min = 3, max = 50)
    @Column(length = 51, nullable = false)
    private String nome;
    
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{senha.not.blank}")
    @Length(min = 6, max = 20, message = "O nome deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(length = 51, nullable = false)
    private String senha;

    @NotBlank(message = "{confirmacao.not.blank}")
    @Length(min = 6, max = 20, message = "O nome deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(length = 51, nullable = false)
    private String confirmacao;

    public Usuario transformaParaObjeto(){
        return new Usuario(nome, email, senha);
    }


}
