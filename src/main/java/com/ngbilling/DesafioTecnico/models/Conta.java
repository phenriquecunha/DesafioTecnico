package com.ngbilling.DesafioTecnico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_conta")
public class Conta {
    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;
    @Column(nullable = false)
    private BigDecimal saldo;
}
