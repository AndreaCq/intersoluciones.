package com.intersoluciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intersoluciones.entities.BancosActivos;


@Repository
public interface BancosActivosRepository extends JpaRepository<BancosActivos, Integer>{

}
