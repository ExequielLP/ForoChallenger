package Proyecto_Foro_Oracle.Foro.servis;

import Proyecto_Foro_Oracle.Foro.dto.TopicoDto;
import Proyecto_Foro_Oracle.Foro.entity.Topico;
import Proyecto_Foro_Oracle.Foro.record.ActualizarTopico;
import Proyecto_Foro_Oracle.Foro.record.CrearTopico;
import Proyecto_Foro_Oracle.Foro.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicosServis {
    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoDto crearTopico(CrearTopico topico) {
        try {
            Topico topicoDb = new Topico(topico);
            topicoRepository.save(topicoDb);
            TopicoDto topicoDto = new TopicoDto(topicoDb);
            return topicoDto;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }

    }


    public TopicoDto upgrateTopico(ActualizarTopico topicoUpgrate) {
        Topico topico = topicoRepository.findById(topicoUpgrate.id())
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con ID: " + topicoUpgrate.id()));
        topico.setTitulo(topicoUpgrate.titulo());
        topico.setMensaje(topicoUpgrate.mensaje());
        topicoRepository.save(topico);
        TopicoDto topicoDto=new TopicoDto(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaDeCreacion(),topico.isEstado());

        return topicoDto;
    }
}
