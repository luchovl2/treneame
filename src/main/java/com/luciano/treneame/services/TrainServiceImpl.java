package com.luciano.treneame.services;

import com.luciano.treneame.entities.Estacion;
import com.luciano.treneame.entities.Linea;
import com.luciano.treneame.repositories.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService
{
    private final TrainRepository repository;

    public TrainServiceImpl(TrainRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Linea> getLineas()
    {
        return repository.findAll();
    }

    @Override
    public List<Estacion> getEstaciones()
    {
        return null;
    }
}
