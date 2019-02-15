package com.luciano.treneame.services;

import com.luciano.treneame.entities.Estacion;
import com.luciano.treneame.entities.Linea;
import com.luciano.treneame.repositories.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public List<Estacion> getEstaciones(int lineaId)
    {
        return repository.getOne(lineaId).getEstaciones();
    }

    @Override
    public List<Integer> getNextTrainsArrivals(int lineaId, int estacionId)
    {
        //dummy data pa' probar

        Random random = new Random();

        //trenes en un sentido
        List<Integer> trainsLeft = new ArrayList<>(3);

        trainsLeft.add(random.nextInt(31));
        trainsLeft.add(random.nextInt(31));
        trainsLeft.add(random.nextInt(31));

        trainsLeft.sort(Integer::compare);

        //trenes en el otro sentido
        List<Integer> trainsRight = new ArrayList<>(3);

        trainsRight.add(random.nextInt(31));
        trainsRight.add(random.nextInt(31));
        trainsRight.add(random.nextInt(31));

        trainsRight.sort(Integer::compare);

        trainsLeft.addAll(trainsRight);

        return trainsLeft;
    }


}
