package com.luciano.treneame.repositories;

import com.luciano.treneame.entities.Linea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Linea, Integer>
{
}
