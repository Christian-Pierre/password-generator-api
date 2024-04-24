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

import com.dev.passwordgen.core.dto.PasswordDTO;
import com.dev.passwordgen.core.dto.PasswordGeneratedDTO;
import com.dev.passwordgen.core.model.Password;
import com.dev.passwordgen.core.service.GenerateRulesService;
import com.dev.passwordgen.core.service.PasswordService;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @Autowired private PasswordService passwordService;
    @Autowired private GenerateRulesService generateRulesService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PasswordDTO>> getPassword(@PathVariable Long userId){
        return new ResponseEntity<>(passwordService.getPassword(userId), HttpStatus.OK);
    }
    @GetMapping("/generate")
    public ResponseEntity<PasswordGeneratedDTO> generatePassword(){
        return new ResponseEntity<>(generateRulesService.generatePassword(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Password> addPassword(@RequestBody Password password){
        return new ResponseEntity<>(passwordService.savePassword(password), HttpStatus.CREATED);
    }
}
