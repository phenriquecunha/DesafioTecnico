package com.ngbilling.DesafioTecnico.DTOs;

import com.ngbilling.DesafioTecnico.enums.FormaPagamentoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
    private FormaPagamentoEnum formaPagamento;
    private Long numeroConta;
    private BigDecimal valor;
}
