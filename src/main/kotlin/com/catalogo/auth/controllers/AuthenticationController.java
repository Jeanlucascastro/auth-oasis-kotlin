package com.catalogo.auth.controllers;

import com.catalogo.auth.domain.Company;
import com.catalogo.auth.domain.user.*;
import com.catalogo.auth.security.TokenService;
import com.catalogo.auth.repositories.UserRepository;
import com.catalogo.auth.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        User user = (User) this.repository.findByLogin(data.login());
        UserDTO  userDTO = new UserDTO(user.getId(), user.getLogin(), user.getUsername());
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, userDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Company company = this.companyService.findbyId(data.companyId());

        User newUser = new User(data.login(), encryptedPassword, data.role(), company);

        newUser.setCompany(company);

        User save = this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
