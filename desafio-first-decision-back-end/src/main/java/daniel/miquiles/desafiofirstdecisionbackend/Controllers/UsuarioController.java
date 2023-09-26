package daniel.miquiles.desafiofirstdecisionbackend.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import daniel.miquiles.desafiofirstdecisionbackend.Dto.UsuarioRequestDTO;
import daniel.miquiles.desafiofirstdecisionbackend.Dto.UsuarioResponseDTO;
import daniel.miquiles.desafiofirstdecisionbackend.Services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@CrossOrigin()
@RestController()
@Validated
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioResponseDTO create(@RequestBody @Valid @NotNull UsuarioRequestDTO usuarioDTO) {
        return usuarioService.create(usuarioDTO);
    }
    
}
