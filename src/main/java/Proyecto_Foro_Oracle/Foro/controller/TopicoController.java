package Proyecto_Foro_Oracle.Foro.controller;

import Proyecto_Foro_Oracle.Foro.dto.TopicoDto;
import Proyecto_Foro_Oracle.Foro.entity.Topico;
import Proyecto_Foro_Oracle.Foro.record.CrearTopico;
import Proyecto_Foro_Oracle.Foro.repository.TopicoRepository;
import Proyecto_Foro_Oracle.Foro.servis.TopicosServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicosServis topicosServis;
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping("crarTopico")
    public ResponseEntity<TopicoDto> crearTopico(@RequestBody CrearTopico topico) {
        return ResponseEntity.ok(topicosServis.crearTopico(topico));
    }
    @GetMapping("/listarTopico")
    public ResponseEntity<List<TopicoDto>> listarTopicos() {
        List<TopicoDto> listaDto = topicoRepository.findAll()
                .stream()
                .map(topico -> new TopicoDto(topico)).toList();
        return ResponseEntity.ok(listaDto);
    }
}
