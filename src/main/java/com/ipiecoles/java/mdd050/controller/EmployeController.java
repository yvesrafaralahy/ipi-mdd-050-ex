package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @RequestMapping("/employe")
    public Employe findById(@RequestParam(value = "id") Long id){
        return employeService.findById(id);
    }
}
