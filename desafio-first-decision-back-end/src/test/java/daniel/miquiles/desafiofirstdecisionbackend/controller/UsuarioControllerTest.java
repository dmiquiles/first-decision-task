package daniel.miquiles.desafiofirstdecisionbackend.controller;

import daniel.miquiles.desafiofirstdecisionbackend.Models.Usuario;
import daniel.miquiles.desafiofirstdecisionbackend.Repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UsuarioRepository usuarioRepository;

    Usuario usuario;

    @BeforeEach
    public void setUp(){
        usuario = new Usuario();
        usuario.setNome("Daniel Miquiles");
        usuario.setEmail("email@email.com");
        usuario.setSenha("123456");
    }

    @Test
    void buscarUsuarios() throws Exception {

        Mockito.when(usuarioRepository.findAll()).thenReturn(List.of(usuario));
        this.mockMvc.perform(get("/api/usuarios"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{nome:'Daniel Miquiles', email:'email@email.com',senha:'123456'}]"));
    }

    @Test
    void salvarAluno() throws Exception {
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        this.mockMvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Daniel Miquiles\",\"email\":\"email@email.com\", \"senha\": \"123456\", \"confirmacao\": \"123456\"}")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Daniel Miquiles"))
                .andExpect(content().json("{nome:'Daniel Miquiles', email:'email@email.com',senha:'123456'}"));
    }


}
