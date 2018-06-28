package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ipiecoles.java.mdd050.model.Employe;
//import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/employes")
public class EmployeController {

    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
	
    @Autowired
	public EmployeService employeService;

    @RequestMapping(value = "/count", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
    public Long count(){
        return employeService.countAllEmploye();
    }
    

    @RequestMapping(value = "", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET, params = "matricule")
    public Employe findByMatricule(@RequestParam("matricule") String matricule){
        return employeService.findMyMatricule(matricule);
    }
    
    @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
    public Employe findById(@PathVariable(value = "id") Long id){
        Employe employe = employeService.findById(id);
        if(employe == null){
            throw new EntityNotFoundException("L'employé d'identifiant : " + id + " n'a pas été trouvé.");
        }
        return employe;
    }
    
    @RequestMapping(value = "", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
    public Page<Employe> findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sortDirection") String sortDirection, @RequestParam("sortProperty") String sortProperty){
        return employeService.findAllEmployes(page, size, sortProperty, sortDirection);
    }

    
    //Overide le comportement de la gestion d'erreur: pour les cas particuliers
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handEntityNotFoundException( EntityNotFoundException entityNotFoundException) {
    return "ERREUR !!!";
    }
    
}
    
