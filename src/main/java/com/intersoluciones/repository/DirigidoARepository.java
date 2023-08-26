package com.intersoluciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intersoluciones.entities.DirigidoA;

@Repository
public interface DirigidoARepository  extends JpaRepository<DirigidoA, Integer>{

}
