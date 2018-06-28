package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.exception.EmployeException;
import com.ipiecoles.java.mdd050.model.Commercial;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/commercials")
public class CommercialController extends EmployeController {

    /**
     *
     * @param id
     * @param employe
     * @return
     */
   
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8, value = "")
    public Commercial createEmploye(@RequestBody Commercial employe) {
        return this.employeService.creerEmploye(employe);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Commercial updateEmploye(@PathVariable(value = "id") Long id, @RequestBody Commercial employe) {
        try {
            return this.employeService.updateEmploye(id, employe);
        } catch (EmployeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
    
}
