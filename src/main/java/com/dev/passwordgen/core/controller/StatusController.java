package com.dev.passwordgen.core.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.passwordgen.core.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired private StatusService service;

    @GetMapping
    public ResponseEntity<Date> getStatus(){
        return new ResponseEntity<>(service.getStatus(), HttpStatus.OK);
    }
}
