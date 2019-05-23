package com.example.AvistamientoDeAves.controller;

import com.example.AvistamientoDeAves.model.AvistamientoAves;
import com.example.AvistamientoDeAves.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Avistamiento")
@RequiredArgsConstructor
public class AvistamientoAvesController {
    private final List<AvistamientoAves> avistamientoAvesList;
    private final PersonController personController;

    @PostMapping("/save")
    public String postSaveAvistamientoAves(@RequestBody AvistamientoAves avistamientoAves,
                                           @RequestParam(required = false, defaultValue = "") String dni){
        if (dni.equals("")) {
            avistamientoAvesList.add(avistamientoAves);
        } else {
            Person person = personController.getSearchPerson(dni);
            avistamientoAves.setPerson(person);
            avistamientoAvesList.add(avistamientoAves);
        }
        return "saved successfully";
    }
    @GetMapping("/view")
    public List<AvistamientoAves> getViewAvistamientoAves(){
        return avistamientoAvesList;
    }

}
