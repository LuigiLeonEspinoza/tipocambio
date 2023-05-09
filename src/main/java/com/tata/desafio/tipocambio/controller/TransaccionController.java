package com.tata.desafio.tipocambio.controller;

import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.Transaccion;
import com.tata.desafio.tipocambio.model.dto.TransaccionDto;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import com.tata.desafio.tipocambio.service.ITransaccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);
    @Autowired
    private ITransaccionService iTransaccionService;
    @GetMapping("")
    public ResponseEntity getTransaccion(@RequestHeader("Authorization") String token){
        try {

            return new ResponseEntity(iTransaccionService.GetTransaccionCliente(token), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping()
    public ResponseEntity saveTransaccion(@RequestHeader("Authorization") String token,@RequestBody TransaccionDto entity){
        try {
            return new ResponseEntity(iTransaccionService.saveTransaccion(token,entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
