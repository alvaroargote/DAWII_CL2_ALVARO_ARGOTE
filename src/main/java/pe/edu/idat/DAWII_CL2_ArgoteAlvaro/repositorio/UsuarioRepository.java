package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.modelo.Usuario;

import java.util.Optional;

public interface UsuarioRepository  extends CrudRepository<Usuario,Integer> {
    @Query("select  u from Usuario u where u.nomusuario =?1")
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
