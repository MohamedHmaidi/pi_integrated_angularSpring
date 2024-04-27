package Hend.BackendSpringboot.controller;


import Hend.BackendSpringboot.config.AuthenticationRequest;
import Hend.BackendSpringboot.config.AuthenticationResponse;
import Hend.BackendSpringboot.config.RegisterRequest;
import Hend.BackendSpringboot.entity.User;
import Hend.BackendSpringboot.repository.UserRepository;
import Hend.BackendSpringboot.service.AuthService;
import Hend.BackendSpringboot.service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody @Valid RegisterRequest registerRequest
    ) {
        authService.register(registerRequest);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }


    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id_user) {
        User user = userService.getUserById(id_user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateID/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id_user, @RequestBody User user) {
        User updatedUser = userService.updateUser(id_user, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id_user) {
        userService.deleteUser(id_user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/allUser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers() {
        List<User> allUser = userService.retrieveAllUser();
        return allUser ;
    }
}




