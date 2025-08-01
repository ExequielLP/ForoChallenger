package Proyecto_Foro_Oracle.Foro.repository;

import Proyecto_Foro_Oracle.Foro.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findOneByName(String userName);
}
