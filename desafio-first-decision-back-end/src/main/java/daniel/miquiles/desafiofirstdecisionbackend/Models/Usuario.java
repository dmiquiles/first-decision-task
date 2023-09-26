package daniel.miquiles.desafiofirstdecisionbackend.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    Long id;
    String nome;
    String email;
    String senha;

}
