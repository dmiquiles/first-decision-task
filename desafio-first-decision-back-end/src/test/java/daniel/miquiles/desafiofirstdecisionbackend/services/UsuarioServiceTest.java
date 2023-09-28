package daniel.miquiles.desafiofirstdecisionbackend.services;

import daniel.miquiles.desafiofirstdecisionbackend.Dto.UsuarioRequestDTO;
import daniel.miquiles.desafiofirstdecisionbackend.Dto.UsuarioResponseDTO;
import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import daniel.miquiles.desafiofirstdecisionbackend.Repositories.UsuarioRepository;
import daniel.miquiles.desafiofirstdecisionbackend.Services.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {

    UsuarioRequestDTO usuarioRequestDTO;
    UsuarioResponseDTO usuarioResponseDTO;
    Usuario usuario;

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @BeforeEach
    public void setUp(){
        usuario = new Usuario();
        usuario.setNome("Daniel Miquiles");
        usuario.setEmail("email@email.com");
        usuario.setSenha("123456");
    }

    @Test
    void usuarioSalvoComSucesso() {
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Assertions.assertEquals(usuarioRequestDTO.getEmail(), usuarioResponseDTO.getEmail());
    }


}
