package com.example.AvistamientoDeAves.controller;

import com.example.AvistamientoDeAves.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final List<Person> personList;

    @PostMapping("/save")
    public String postSavePerson(@RequestBody Person person1){
        personList.add(person1);
        return "saved successfully";
    }
    @GetMapping("/view")
    public List<Person> getViewPerson(){
        return personList;
    }
    @GetMapping("/searchName")
    public Person getSearchPerson(@RequestParam String dni){
        for (Person person1:
             personList) {
            if(dni.equals(person1.getDni())){
                return person1;
            }
        }
        return null;
    }
}
