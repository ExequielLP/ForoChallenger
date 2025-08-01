package Proyecto_Foro_Oracle.Foro.dto;

import Proyecto_Foro_Oracle.Foro.entity.Autor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {
    private String name;
    private String jwt;

    public AutorDto(Autor autor) {
        this.name=autor.getName();
    }
}
