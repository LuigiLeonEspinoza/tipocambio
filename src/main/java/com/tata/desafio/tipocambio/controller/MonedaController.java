package com.tata.desafio.tipocambio.controller;


import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.service.IMonedaService;
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
@RequestMapping("/moneda")
public class MonedaController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);
    @Autowired
    private IMonedaService iMonedaService;

    @PostMapping()
    public ResponseEntity saveMoneda(@RequestBody Moneda entity){
        try {
            return new ResponseEntity(iMonedaService.saveMoneda(entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
