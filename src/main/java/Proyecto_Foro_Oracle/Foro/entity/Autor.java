package Proyecto_Foro_Oracle.Foro.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "autor")
    private Topico topico;
}
