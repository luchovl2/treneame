package com.luciano.treneame.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Linea
{
    @Id
    private int id;
    private String name;
    @ElementCollection
    private List<Estacion> estaciones = new ArrayList<>();

    public Linea()
    {
    }

    public Linea(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Linea(int id, String name, List<Estacion> estaciones)
    {
        this.id = id;
        this.name = name;
        this.estaciones = estaciones;
    }

    public void addEstacion(Estacion estacion)
    {
        estaciones.add(estacion);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Estacion> getEstaciones()
    {
        return estaciones;
    }

    public void setEstaciones(List<Estacion> estaciones)
    {
        this.estaciones = estaciones;
    }
}
