package com.ngbilling.DesafioTecnico.controllers;

import com.ngbilling.DesafioTecnico.models.Conta;
import com.ngbilling.DesafioTecnico.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Object> criarConta(@RequestBody Conta contaNova){
        Conta contaCriada;
        try {
            contaCriada = this.contaService.criarConta(contaNova);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar conta");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaCriada);
    }

    @GetMapping
    public ResponseEntity<Object> consultarConta(@RequestParam("numeroConta") Long numeroConta){
        Conta conta;
        try{
            conta = this.contaService.consultarConta(numeroConta);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(conta);
    }
}
