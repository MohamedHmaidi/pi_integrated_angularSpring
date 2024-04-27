package Hend.BackendSpringboot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/auth/login","/auth/register" ).permitAll()

                        .requestMatchers("/auth/allUser").hasAuthority("ADMIN")
                        .requestMatchers("/incident/retrieve-all-incidents").hasAuthority("ADMIN")
                        .requestMatchers("/incident/retrieve-incident/{incident-id}").hasAuthority("ADMIN")
                        .requestMatchers("/incident/remove-incident/{incident-id}").hasAuthority("ADMIN")
                        .requestMatchers("/incident/modify-incident").hasAuthority("ADMIN")
                        .requestMatchers("/incident/add-incident").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers("/incidentType/****").hasAuthority("ADMIN")
                        .requestMatchers("/api/training-content").hasAuthority("ADMIN")
                       // .requestMatchers("/api/quizzes/{quizId}/questions").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/{quizId}/questions/{id}").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers(HttpMethod.PUT,"/api/quizzes/{quizId}/questions/{id}").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/quizzes/{quizId}/questions")
                        .hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/quizzes/{quizId}/questions")
                        .hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/quizzes/{quizId}/questions/{id}")
                        .hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/{id}").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/ByTrainingContent/{trainingContentId}").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/quizzes").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/quizzes/{id}").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/statistics/mostPopularQuizType").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/statistics/totalQuizzesCount").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/quizzes/statistics/averageQuizScore").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/quizzes/{id}").hasAuthority("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}



