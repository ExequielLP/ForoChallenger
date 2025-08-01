package Proyecto_Foro_Oracle.Foro.controller;

import Proyecto_Foro_Oracle.Foro.dto.AutorDto;
import Proyecto_Foro_Oracle.Foro.entity.Autor;
import Proyecto_Foro_Oracle.Foro.record.AutheticationRequest;
import Proyecto_Foro_Oracle.Foro.record.RegistrarAutor;
import Proyecto_Foro_Oracle.Foro.servis.AutorServis;
import Proyecto_Foro_Oracle.Foro.servis.auth.JwtServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AutheticationController {
    @Autowired
    private JwtServis jwtServis;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AutorServis autorServis;

    @GetMapping("/login")
    public ResponseEntity<AutorDto> login(@RequestBody AutheticationRequest autheticationRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(autheticationRequest.name(),
                autheticationRequest.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = jwtServis.generarToken((Autor) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new AutorDto(usuarioAutenticado.getName(), JWTtoken));
    }


}

