package com.luciano.treneame.bootstrap;

import com.luciano.treneame.entities.Estacion;
import com.luciano.treneame.entities.Linea;
import com.luciano.treneame.repositories.TrainRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner
{
    private final TrainRepository repository;

    public BootstrapData(TrainRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Loading the data, vieja...");

        Linea linea1 = new Linea(1, "Sarmiento");
        linea1.addEstacion(new Estacion(1, "Moreno"));
        linea1.addEstacion(new Estacion(2, "Merlo"));
        linea1.addEstacion(new Estacion(3, "Haedo"));
        linea1.addEstacion(new Estacion(4, "Liniers"));

        Linea linea2 = new Linea(2, "Mitre");
        linea2.addEstacion(new Estacion(1, "estacion 21"));
        linea2.addEstacion(new Estacion(2, "estacion 22"));
        linea2.addEstacion(new Estacion(3, "estacion 23"));

        Linea linea3 = new Linea(3, "Urquiza");
        linea3.addEstacion(new Estacion(1, "estacion 31"));
        linea3.addEstacion(new Estacion(2, "estacion 32"));
        linea3.addEstacion(new Estacion(3, "estacion 33"));

        repository.save(linea1);
        repository.save(linea2);
        repository.save(linea3);

        System.out.println("The f*cking data is loaded, papá.");
    }
}
