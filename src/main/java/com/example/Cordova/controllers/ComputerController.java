package com.example.Cordova.controllers;

import com.example.Cordova.models.Computer;
import com.example.Cordova.models.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    @PostMapping("/createcomputer")
    public Computer createcomputer(){
        Computer computer = new Computer(){

        };
        computerRepository.save(computer);
        return computer;
    }

    @GetMapping("/getcomputers")
    public List<Computer> getallcomputers(){
        List<Computer> computers = computerRepository.findAll();
        return computers;
    }
}
