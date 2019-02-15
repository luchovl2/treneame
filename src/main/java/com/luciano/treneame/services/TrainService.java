package com.luciano.treneame.services;

import com.luciano.treneame.entities.Estacion;
import com.luciano.treneame.entities.Linea;

import java.util.List;

public interface TrainService
{
    List<Linea> getLineas();
    List<Estacion> getEstaciones(int lineaId);
    List<Integer> getNextTrainsArrivals(int lineaId, int estacionId);
}
