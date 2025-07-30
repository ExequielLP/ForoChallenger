package Proyecto_Foro_Oracle.Foro.record;

import Proyecto_Foro_Oracle.Foro.entity.Autor;
import Proyecto_Foro_Oracle.Foro.entity.Curso;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.NonNull;

import java.time.LocalDate;

public record CrearTopico(@NonNull String titulo, @NonNull String mensaje, @NonNull LocalDate fechaDeCreacion,
                          boolean estado, @NonNull Autor autor, @NonNull Curso curso) {


}
