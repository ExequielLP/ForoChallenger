package Proyecto_Foro_Oracle.Foro.record;


import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record RegistrarAutor(@NotBlank String name, @NotBlank String apellido, @NotBlank String password) {
}
