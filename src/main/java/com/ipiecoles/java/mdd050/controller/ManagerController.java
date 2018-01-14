package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.exception.EmployeException;
import com.ipiecoles.java.mdd050.model.Manager;
import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/managers")
public class ManagerController extends EmployeController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Manager updateEmploye(@PathVariable(value = "id") Long id, @RequestBody Manager employe) {
        try {
            return this.employeService.updateEmploye(id, employe);
        } catch (EmployeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }


    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8, value = "")
    public Manager createEmploye(@RequestBody Manager employe) {
        return this.employeService.creerEmploye(employe);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idManager}/equipe/{idTechnicien}/remove")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTechniciens(@PathVariable Long idManager, @PathVariable Long idTechnicien) {
        try{
            this.managerService.deleteTechniciens(idManager, idTechnicien);
        } catch (Exception e){

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idManager}/equipe/{matricule}/add")
    @ResponseStatus(value = HttpStatus.OK)
    public Technicien addTechniciens(@PathVariable Long idManager, @PathVariable String matricule) {
        return this.managerService.addTechniciens(idManager, matricule);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmploye(@PathVariable Long id) {
        try {
            employeService.deleteEmploye(id);
        } catch (IllegalArgumentException e){
            throw new EntityNotFoundException("L'employé d'identifiant : " + id + " n'a pas été trouvé.");
        }
    }
}
