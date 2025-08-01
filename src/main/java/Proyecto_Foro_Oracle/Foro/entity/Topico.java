package Proyecto_Foro_Oracle.Foro.entity;

import Proyecto_Foro_Oracle.Foro.record.CrearTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(unique = true)
    private String titulo;
    @NonNull
    @Column(unique = true)
    private String mensaje;
    @NonNull
    private LocalDate fechaDeCreacion;
    private boolean estado=true;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    private Autor autor;
    @OneToOne(cascade = CascadeType.ALL)
    private Curso curso;

    public Topico(CrearTopico crearTopico) {
        this.titulo = crearTopico.titulo();
        this.mensaje = crearTopico.mensaje();
        this.fechaDeCreacion = crearTopico.fechaDeCreacion();
        this.estado = true;
        this.autor = crearTopico.autor();
        this.curso = crearTopico.curso();
    }
}
