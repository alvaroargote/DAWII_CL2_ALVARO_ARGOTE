package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "rol")
public class rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    private String nombrerol;
}
