package daniel.miquiles.desafiofirstdecisionbackend.Models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Length(min = 3, max = 50)
    @Column(length = 51, nullable = false)
    String nome;
    
    @NotBlank
    @Email
    String email;

    @NotBlank
    @Length(min = 6, max = 20)
    @Column(length = 51, nullable = false)
    String senha;

}
