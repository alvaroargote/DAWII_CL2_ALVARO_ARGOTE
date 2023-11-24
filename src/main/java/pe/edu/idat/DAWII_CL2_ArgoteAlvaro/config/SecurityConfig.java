package pe.edu.idat.DAWII_CL2_ArgoteAlvaro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.idat.DAWII_CL2_ArgoteAlvaro.security.CustomSecurityService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomSecurityService customSecurityService;

    public SecurityConfig(CustomSecurityService customSecurityService) {
        this.customSecurityService = customSecurityService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(x -> x.requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/index/**").hasRole("USER")
                        .anyRequest().permitAll())
                .formLogin(
                        formLogin -> formLogin.loginPage("/signin").loginProcessingUrl("/login")
                                .defaultSuccessUrl("/index")
                                .permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/signin").invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customSecurityService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
