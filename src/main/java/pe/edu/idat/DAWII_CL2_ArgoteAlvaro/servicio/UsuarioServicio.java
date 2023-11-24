package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.servicio;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.dto.UsuarioRequest;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.modelo.Usuario;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.repositorio.UsuarioRepository;

@Service
public class UsuarioServicio {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioServicio(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario registrar(UsuarioRequest usuarioRequest) {
        Usuario usuario = Usuario.builder()
                .nomusuario(usuarioRequest
                        .getNomusuario())
                .email(usuarioRequest.getEmail())
                .password(passwordEncoder.encode(usuarioRequest.getPassword()))
                .nombres(usuarioRequest.getNombres())
                .apellidos(usuarioRequest.getApellidos())
                .telefono(usuarioRequest.getTelefono())
                .build();
        return usuarioRepository.save(usuario);
    }
}
