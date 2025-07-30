package Proyecto_Foro_Oracle.Foro.entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreDeCurso;
    @OneToOne(mappedBy = "curso")
    private Topico topico;
}
