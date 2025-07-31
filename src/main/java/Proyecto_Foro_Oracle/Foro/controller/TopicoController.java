package Proyecto_Foro_Oracle.Foro.controller;

import Proyecto_Foro_Oracle.Foro.dto.TopicoDto;
import Proyecto_Foro_Oracle.Foro.record.ActualizarTopico;
import Proyecto_Foro_Oracle.Foro.record.CrearTopico;
import Proyecto_Foro_Oracle.Foro.repository.TopicoRepository;
import Proyecto_Foro_Oracle.Foro.servis.TopicosServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicosServis topicosServis;
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping("/crarTopico")
    public ResponseEntity<TopicoDto> crearTopico(@RequestBody @Valid CrearTopico topico) {
        return ResponseEntity.ok(topicosServis.crearTopico(topico));
    }

    @GetMapping("/listarTopico")
    public ResponseEntity<List<TopicoDto>> listarTopicos() {
        List<TopicoDto> listaDto = topicoRepository.findAll()
                .stream()
                .map(TopicoDto::new).toList();
        return ResponseEntity.ok(listaDto);
    }

    @PutMapping("/actualizarTopico")
    public ResponseEntity<TopicoDto> actualizarTopico(@RequestBody ActualizarTopico topicoUpgrate) {
        System.out.println("-------------------------------------------------------------------------");
        TopicoDto topicoDto = topicosServis.upgrateTopico(topicoUpgrate);
        return ResponseEntity.ok(topicoDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        return ResponseEntity.ok((topicoRepository.findById(id).map(topico -> {
            topico.setEstado(false);
            topicoRepository.save(topico);
            return topico;
        })));
    }

    @DeleteMapping("/eliminarDb/{id}")
    public void eliminarDb(@PathVariable Long id) {
        topicoRepository.findById(id)
                .ifPresentOrElse(
                        topico -> topicoRepository.deleteById(topico.getId()),
                        () -> {
                            throw new RuntimeException("No existe el ID");
                        }
                );
    }

    @GetMapping("/detalleTopico/{id}")
    public ResponseEntity<TopicoDto> detalleTopico(@PathVariable Long id) {
        return ResponseEntity.ok(
                topicoRepository.findById(id)
                        .map(topico -> new TopicoDto(topico))
                        .orElseThrow(() -> new RuntimeException("No se encontró el ID"))
        );
    }

}
