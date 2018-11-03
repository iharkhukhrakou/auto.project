package auto.project.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //.antMatchers("/css/**", "/js/**", "/img/**","/favicon.ico").permitAll()
                .antMatchers("/user/registration", "/user/confirm").permitAll();
        //        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        //        .anyRequest().authenticated()
        //        .and()
        //        .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", false)
        //        .and()
        //        .logout().permitAll()
        //        .and()
        //        .exceptionHandling().accessDeniedPage("/403")
        //        .and()
        //        .rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(1209600)
        //        .rememberMeCookieName(REMEMBER_ME_COOKIE);
    }
}
