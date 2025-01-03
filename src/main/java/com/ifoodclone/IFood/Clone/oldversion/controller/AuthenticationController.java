package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.dto.authentication.AuthenticationDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.token.TokenDTO;
import com.ifoodclone.IFood.Clone.oldversion.service.TokenService;
import com.ifoodclone.IFood.Clone.oldversion.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> loginUser(@RequestBody @Valid AuthenticationDTO data) {
        var token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }


}
