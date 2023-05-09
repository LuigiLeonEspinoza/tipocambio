package com.tata.desafio.tipocambio.controller;

import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.dto.TipoCambioDto;
import com.tata.desafio.tipocambio.model.dto.TipoCambioUpd;
import com.tata.desafio.tipocambio.service.IClienteService;
import com.tata.desafio.tipocambio.service.IMonedaService;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {
    private static final Logger logger = LoggerFactory.getLogger(MonedaController.class);
    @Autowired
    private ITipoCambioService iTipoCambioService;
    @Autowired
    private IClienteService iClienteService;

    @PostMapping()
    public ResponseEntity saveTipoCambio(@RequestHeader("Authorization") String token,@RequestBody TipoCambioDto entity){
        try {
            if(iClienteService.ValidateToken(token)==null){
                return new ResponseEntity("Token no Admitido", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(iTipoCambioService.saveTipoCambio(entity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity UpdateTipoCambio(@RequestHeader("Authorization") String token,@PathVariable("id") Long id,@RequestBody TipoCambioUpd entity){
        try {
            if(iClienteService.ValidateToken(token)==null){
                return new ResponseEntity("Token no Admitido", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(iTipoCambioService.UpdateTipoCambio(id,entity), HttpStatus.OK);
        }catch (Exception e){
            logger.error("ERROR:  " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
