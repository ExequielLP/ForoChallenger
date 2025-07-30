package Proyecto_Foro_Oracle.Foro.dto;

import Proyecto_Foro_Oracle.Foro.entity.Topico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicoDto {
    @NonNull
    private Long id;
    @NonNull
    private String titulo;
    @NonNull
    private String mensaje;
    @NonNull
    private LocalDate fechaDeCreacion;
    private boolean estado;
    public TopicoDto(Topico topicoDb) {
        this.id=topicoDb.getId();
        this.titulo=topicoDb.getTitulo();
        this.mensaje=topicoDb.getMensaje();
        this.fechaDeCreacion=topicoDb.getFechaDeCreacion();
        this.estado=topicoDb.isEstado();
    }
}
