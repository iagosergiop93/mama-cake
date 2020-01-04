package com.cake.controllers;

import com.cake.dtos.CakeDto;
import com.cake.entities.Cake;
import com.cake.exceptions.CustomException;
import com.cake.services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cakes")
public class CakeController {

    private CakeService cakeService;

    @Autowired
    CakeController(CakeService cakeService){
        this.cakeService = cakeService;
    }

    @GetMapping(produces = "application/json")
    public List<Cake> getCakes() {
        return cakeService.getAllCakes();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping("/id/{id}")
    public Cake getCakes(@PathVariable Long id) {
        if(id == null || id == 0) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return cakeService.getCakeById(id);
    }

    @PostMapping(produces = "application/json")
    public Cake postCake(@RequestBody CakeDto cakeDto) {
        if(cakeDto == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return cakeService.insertCake(new Cake(cakeDto));
    }

    @PutMapping(produces = "application/json")
    public Cake updateCake(@RequestBody Cake cake) {
        if(cake == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return cakeService.updateCake(cake);
    }

}
