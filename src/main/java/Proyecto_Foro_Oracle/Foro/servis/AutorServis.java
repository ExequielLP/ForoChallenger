package Proyecto_Foro_Oracle.Foro.servis;

import Proyecto_Foro_Oracle.Foro.dto.AutorDto;
import Proyecto_Foro_Oracle.Foro.entity.Autor;
import Proyecto_Foro_Oracle.Foro.record.RegistrarAutor;
import Proyecto_Foro_Oracle.Foro.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AutorServis {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Autor registrarAutorDB(RegistrarAutor registrarAutor) {
        Autor autor = autorRepository.save(new Autor(null, registrarAutor.name(), registrarAutor.apellido(), passwordEncoder.encode(registrarAutor.password()), null));

        return autor;
    }
}
