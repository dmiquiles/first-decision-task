package daniel.miquiles.desafiofirstdecisionbackend.Dto;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
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
