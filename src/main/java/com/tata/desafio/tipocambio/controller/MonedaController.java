package com.tata.desafio.tipocambio.controller;


import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.service.IMonedaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moneda")
public class MonedaController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);
    @Autowired
    private IMonedaService iMonedaService;
    @GetMapping("/all")
    public ResponseEntity getMonedaAll(){
        try {
            return new ResponseEntity(iMonedaService.getMonedaAll(), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity getMoneda(@PathVariable long id){
        try {
            return new ResponseEntity(iMonedaService.getMoneda(id), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping()
    public ResponseEntity saveMoneda(@RequestBody Moneda entity){
        try {
            return new ResponseEntity(iMonedaService.saveMoneda(entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity putMoneda(@PathVariable long id,@RequestBody Moneda entity){
        try {
            return new ResponseEntity(iMonedaService.putMoneda(id,entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
