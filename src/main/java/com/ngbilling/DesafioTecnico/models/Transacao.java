package com.ngbilling.DesafioTecnico.models;

import com.ngbilling.DesafioTecnico.enums.FormaPagamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_transacao")
public class Transacao {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 1)
    private FormaPagamentoEnum formaPagamento;

    @Column(name = "numero_conta")
    private Long numeroConta;

    @Column(nullable = false)
    private BigDecimal valor;
}
