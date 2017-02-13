package com.consulta.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.cep.entity.Cep;

public interface Ceps extends JpaRepository<Cep, Long> {

}
