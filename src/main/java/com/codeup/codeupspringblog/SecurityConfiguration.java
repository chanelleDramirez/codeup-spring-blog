package com.codeup.codeupspringblog;


import com.codeup.codeupspringblog.Services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout() // sets up the mapping for a user to logout.
                .logoutSuccessUrl("/") // append a query string value
                /* Pages that can be viewed without having to log in */ // this is where the redirect is conducted after the login is complete. should redirect back to the home page.
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/posts", "/posts/{id}","/css/**","/js/**","/register") // anyone can see the home and the ads pages and any other page that is listed in the .requestMatchers.
                .permitAll()// this allows anybody to take a look at the page without being logged in. This also allows the page to read the css.
                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/posts/create", // only authenticated users can create ads and click on the ad to view the sub-page. If not authenticated the user will be re-directed to the login page
                        "/posts/{id}/edit" // only authenticated users can edit ads
                )
                .authenticated()
        ;
        return http.build();
    }
}
