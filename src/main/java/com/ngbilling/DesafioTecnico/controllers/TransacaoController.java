package com.ngbilling.DesafioTecnico.controllers;

import com.ngbilling.DesafioTecnico.DTOs.TransacaoDTO;
import com.ngbilling.DesafioTecnico.models.Conta;
import com.ngbilling.DesafioTecnico.services.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Object> efetuarTransacao(@RequestBody TransacaoDTO transacaoDTO){
        Conta conta;
        try {
            conta = this.transacaoService.efetuarTransacao(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(conta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
