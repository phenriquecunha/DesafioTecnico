package com.ngbilling.DesafioTecnico.repositories;

import com.ngbilling.DesafioTecnico.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
