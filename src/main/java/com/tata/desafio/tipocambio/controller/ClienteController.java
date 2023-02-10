package com.tata.desafio.tipocambio.controller;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);

    @Autowired
    private IClienteService iClienteService;
    @PostMapping()
    public ResponseEntity saveClient(@RequestBody Cliente entity){
        try {
            return new ResponseEntity(iClienteService.saveClient(entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Cliente entity){
        try {
            return new ResponseEntity(iClienteService.getClient(entity), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
