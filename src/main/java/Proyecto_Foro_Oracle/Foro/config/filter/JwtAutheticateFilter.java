package Proyecto_Foro_Oracle.Foro.config.filter;

import Proyecto_Foro_Oracle.Foro.entity.Autor;
import Proyecto_Foro_Oracle.Foro.repository.AutorRepository;
import Proyecto_Foro_Oracle.Foro.servis.auth.JwtServis;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.persister.collection.OneToManyPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAutheticateFilter extends OncePerRequestFilter {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private JwtServis jwtServis;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeaders = request.getHeader("Authorization");
        if (!StringUtils.hasText(authorizationHeaders) || !authorizationHeaders.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;

        }

        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = jwtServis.getSubject(token); // extract username
            if (nombreUsuario != null) {
                // Token valido
                var usuario = autorRepository.findOneByName(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities()); // Forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);

    }
}

