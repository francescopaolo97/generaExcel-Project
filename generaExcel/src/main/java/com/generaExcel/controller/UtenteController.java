package com.generaExcel.controller;

import com.generaExcel.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utenteController")
public class UtenteController {

    @Autowired
    UtenteService utenteService;
}
