package com.dev.passwordgen.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.passwordgen.core.dto.PasswordGeneratedDto;
import com.dev.passwordgen.core.model.Password;
import com.dev.passwordgen.core.service.PasswordService;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @Autowired private PasswordService service;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Password>> getPassword(@PathVariable Long userId){
        return new ResponseEntity<>(service.getPassword(userId), HttpStatus.OK);
    }
    @GetMapping("/generate")
    public ResponseEntity<PasswordGeneratedDto> generatePassword(){
        return new ResponseEntity<>(service.generatePassword(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Password> addPassword(@RequestBody Password password){
        return new ResponseEntity<>(service.savePassword(password), HttpStatus.CREATED);
    }
}
