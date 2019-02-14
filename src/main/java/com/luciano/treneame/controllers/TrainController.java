package com.luciano.treneame.controllers;

import com.luciano.treneame.entities.Linea;
import com.luciano.treneame.services.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @GetMapping("/error")
    public String error()
    {
        return "error";
    }
}
