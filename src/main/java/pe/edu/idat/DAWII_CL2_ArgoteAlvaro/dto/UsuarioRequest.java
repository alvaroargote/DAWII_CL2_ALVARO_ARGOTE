package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    private String nomusuario;

    private String email;

    private String password;

    private String nombres;

    private String apellidos;

    private String telefono;

}