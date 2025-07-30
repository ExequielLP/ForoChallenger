package Proyecto_Foro_Oracle.Foro.repository;

import Proyecto_Foro_Oracle.Foro.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
