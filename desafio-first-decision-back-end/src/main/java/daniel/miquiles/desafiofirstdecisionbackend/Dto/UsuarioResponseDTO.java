package daniel.miquiles.desafiofirstdecisionbackend.Dto;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public static UsuarioResponseDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }


}
