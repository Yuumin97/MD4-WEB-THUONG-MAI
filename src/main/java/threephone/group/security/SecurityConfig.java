package threephone.group.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import threephone.group.security.jwt.JwtAuthEntryPoint;
import threephone.group.security.jwt.JwtAutoTokenFilter;
import threephone.group.security.userprincipal.UserDetailServiceIMPL;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;
    @Autowired
    private UserDetailServiceIMPL userDetailServiceIMPL;
    @Bean
    public JwtAutoTokenFilter jwtAutoTokenFilter(){
        return new JwtAutoTokenFilter();
    }
}
