package com.luciano.treneame.controllers;

import com.luciano.treneame.entities.Estacion;
import com.luciano.treneame.entities.Linea;
import com.luciano.treneame.services.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("/v1/treneame/")
public class TrainController
{
    private final TrainService service;

    public TrainController(TrainService service)
    {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public String home()
    {
        return "home";
    }

    @GetMapping("/lineas")
    @ResponseBody
    public List<Linea> lineas()
    {
        return service.getLineas();
    }

    @GetMapping("/linea/{id}/estaciones")
    @ResponseBody
    public List<Estacion> estaciones(@PathVariable("id") int lineaId)
    {
        return service.getEstaciones(lineaId);
    }

    @GetMapping("/linea/{lineaId}/{estacionId}")
//    @ResponseBody
    public String nextTrains(Model model,
                             @PathVariable("lineaId")int lineaId,
                             @PathVariable("estacionId")int estacionId)
    {
        List<Estacion>estaciones = service.getEstaciones(lineaId);

        Estacion estacion = estaciones.stream()
                .filter((elem)->elem.getId() == estacionId)
                .findFirst().get();

        model.addAttribute("estacion", estacion.getName());

        List<Integer> trenes = service.getNextTrainsArrivals(lineaId, estacionId);
        model.addAttribute("trenes1", trenes.subList(0, 3));
        model.addAttribute("trenes2", trenes.subList(3, 6));

        return "estacion";
    }

    @GetMapping("/error")
    public String error()
    {
        return "error";
    }
}
