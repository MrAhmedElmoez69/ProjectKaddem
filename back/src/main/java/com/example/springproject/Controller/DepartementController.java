package com.example.springproject.Controller;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Departement;
import com.example.springproject.Service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Departement")
public class DepartementController {
    @Autowired
    private IDepartementService DepartementService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<Departement> getDepartements() {
        List<Departement>  listDepartement = DepartementService.findAll();
        return listDepartement;
    }

    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement ajouterDepartement(@RequestBody Departement D) {
        int Departement = DepartementService.ajouterDepartement(D);
        return D;
    }

    @DeleteMapping("/removeDepartement/{department-id}")
    @ResponseBody
    public void removeDepartement(@PathVariable("department-id") Departement D) {

        DepartementService.DeleteDepartement(D);
    }
    @GetMapping("/retrieveDepartement/{departement-id}")
    @ResponseBody
    public Departement retrieveDepartement(@PathVariable("departement-id") Integer d) { return DepartementService.findById(d); }

    @PutMapping("/modifyDep")
    @ResponseBody
    public Departement updateContrat(@RequestBody Departement d) {
        Boolean departement = DepartementService.UpdateDepartement(d);
        return d;
    }

}
