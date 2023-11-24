package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.controlador;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.dto.ChangePasswordRequest;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.dto.UsuarioRequest;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.servicio.UsuarioServicio;

@Controller
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRequest", new UsuarioRequest());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UsuarioRequest userRequest) {
        usuarioServicio.registrar(userRequest);
        return "redirect:/signin";
    }

    @PatchMapping()
    public String changePassword(@ModelAttribute ChangePasswordRequest changePasswordRequest){
        return "";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.getContext().setAuthentication(null);
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/signin";
    }
}
