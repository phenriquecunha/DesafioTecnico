package com.ngbilling.DesafioTecnico.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public enum FormaPagamentoEnum {

    P("Pix", new BigDecimal("1.0")),// Sem taxa
    C("Cartão de Crédito", new BigDecimal("1.05")),// 5% de taxa
    D("Cartão de Débito", new BigDecimal("1.03"));// 3% de taxa

    private final String descricao;
    private final BigDecimal taxa;

    FormaPagamentoEnum(String descricao, BigDecimal taxa) {
        this.descricao = descricao;
        this.taxa = taxa;
    }

    @JsonValue
    public String getCodigo() {
        return this.name(); // Retorna "P", "C" ou "D" como string no JSON das requisições
    }

    @JsonCreator
    public static FormaPagamentoEnum from(String value) {
        return switch (value.toUpperCase()) {
            case "P" -> P;
            case "C" -> C;
            case "D" -> D;
            default -> throw new IllegalArgumentException("Forma de pagamento inválida: " + value);
        };
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }
}