package daniel.miquiles.firstbackend.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import daniel.miquiles.firstbackend.Dto.UsuarioRequestDTO;
import daniel.miquiles.firstbackend.Dto.UsuarioResponseDTO;
import daniel.miquiles.firstbackend.Services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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
