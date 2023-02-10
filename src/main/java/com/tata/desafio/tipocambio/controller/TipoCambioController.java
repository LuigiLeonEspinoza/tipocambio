package com.tata.desafio.tipocambio.controller;

import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.dto.TipoCambioDto;
import com.tata.desafio.tipocambio.model.dto.TipoCambioUpd;
import com.tata.desafio.tipocambio.service.IMonedaService;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);
    @Autowired
    private ITipoCambioService iTipoCambioService;

    @PostMapping()
    public ResponseEntity saveTipoCambio(@RequestBody TipoCambioDto entity){
        try {
            return new ResponseEntity(iTipoCambioService.saveTipoCambio(entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity UpdateTipoCambio(@PathVariable("id") Long id,@RequestBody TipoCambioUpd entity){
        try {
            return new ResponseEntity(iTipoCambioService.UpdateTipoCambio(id,entity), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
