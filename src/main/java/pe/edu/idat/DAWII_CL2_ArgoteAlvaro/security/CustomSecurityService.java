package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.repositorio.UsuarioRepository;

@Service @RequiredArgsConstructor
public class CustomSecurityService  implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNombreUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado !"));
    }
}
