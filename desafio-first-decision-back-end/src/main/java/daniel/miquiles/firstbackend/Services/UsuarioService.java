package daniel.miquiles.firstbackend.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import daniel.miquiles.firstbackend.Dto.UsuarioRequestDTO;
import daniel.miquiles.firstbackend.Dto.UsuarioResponseDTO;
import daniel.miquiles.firstbackend.Exceptions.SenhasNaoCoincidem;
import daniel.miquiles.firstbackend.Repositories.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;


@Service
@Validated
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
        .stream()
            .map(UsuarioResponseDTO::transformaEmDTO)
            .collect(Collectors.toList());
    }
    
    public UsuarioResponseDTO create(@Valid @NotNull UsuarioRequestDTO usuarioDTO) {

        if(!usuarioDTO.getSenha().equals(usuarioDTO.getConfirmacao())) throw new SenhasNaoCoincidem();

        return UsuarioResponseDTO.transformaEmDTO(usuarioRepository.save(usuarioDTO.transformaParaObjeto()));
    }
}
