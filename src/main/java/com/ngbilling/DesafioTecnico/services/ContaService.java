package com.ngbilling.DesafioTecnico.services;

import com.ngbilling.DesafioTecnico.models.Conta;
import com.ngbilling.DesafioTecnico.repositories.ContaRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    public Conta criarConta(Conta contaNova){
         Optional<Conta> conta = contaRepository.findByNumeroConta(contaNova.getNumeroConta());
         conta.ifPresent(c -> {
             throw new RuntimeException("Conta já existente");
         });
         return contaRepository.save(contaNova);
    }

    public Conta consultarConta(Long numeroConta){
        return this.contaRepository.findByNumeroConta(numeroConta)
                .orElseThrow(() -> new NoSuchElementException("Conta não encontrada"));
    }

    public Conta atualizarConta(Conta conta){
        return this.contaRepository.save(conta);
    }
}
