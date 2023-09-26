package daniel.miquiles.desafiofirstdecisionbackend.Dto;

import org.hibernate.validator.constraints.Length;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioResponseDTO {
    
    private String nome;
    private String email;
    private String senha;

    public static UsuarioResponseDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }


}
