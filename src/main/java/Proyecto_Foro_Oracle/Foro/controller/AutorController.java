package Proyecto_Foro_Oracle.Foro.controller;

import Proyecto_Foro_Oracle.Foro.dto.AutorDto;
import Proyecto_Foro_Oracle.Foro.entity.Autor;
import Proyecto_Foro_Oracle.Foro.record.RegistrarAutor;
import Proyecto_Foro_Oracle.Foro.repository.AutorRepository;
import Proyecto_Foro_Oracle.Foro.servis.AutorServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorServis autorServis;

    @Autowired
    private AutorRepository autorRepository;
    //ACA USO LA CLASE REGISTAR AUTOR TANTO PARA LOGIN COMO PARA CREAR
    @PostMapping("/registrar")
    public ResponseEntity<?> registerOneCostumer(@RequestBody  RegistrarAutor registrarAutor, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorServis.registrarAutorDB(registrarAutor);
        URI url = uriComponentsBuilder.path("/auth/registrar/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(url).body(autor);
    }
    @GetMapping("/listarComunidad")
    public ResponseEntity<List<AutorDto>>listaComunidad(){
        System.out.println("hola");
        return ResponseEntity.ok(autorRepository.findAll().stream().map(autor -> new AutorDto(autor)).toList());
    }

}
