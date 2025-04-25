package com.ngbilling.DesafioTecnico.services;

import com.ngbilling.DesafioTecnico.DTOs.TransacaoDTO;
import com.ngbilling.DesafioTecnico.models.Conta;
import com.ngbilling.DesafioTecnico.models.Transacao;
import com.ngbilling.DesafioTecnico.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransacaoService {

    private final int SALDO_NEGATIVO = -1;
    private final TransacaoRepository transacaoRepository;
    private final ContaService contaService;

    public TransacaoService(TransacaoRepository transacaoRepository, ContaService contaService){
        this.transacaoRepository = transacaoRepository;
        this.contaService = contaService;
    }

    public Conta efetuarTransacao(TransacaoDTO transacaoDTO){
        Conta conta = this.contaService.consultarConta(transacaoDTO.getNumeroConta());
        BigDecimal taxa = transacaoDTO.getFormaPagamento().getTaxa();
        BigDecimal valorTotal = transacaoDTO.getValor().multiply(taxa);
        System.out.println("Total com taxa: " + valorTotal);

        if(conta.getSaldo().compareTo(valorTotal) == SALDO_NEGATIVO){
            throw new RuntimeException("SALDO DA CONTA INSUFICIENTE");
        }

        conta.setSaldo(conta.getSaldo().subtract(valorTotal));
        return this.contaService.atualizarConta(conta);
    }
}
