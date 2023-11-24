package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ChangePasswordRequest {

    private String actualPassword;

    private String newPassword;

    private String confirmPassword;

}
