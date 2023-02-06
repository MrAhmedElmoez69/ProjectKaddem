package com.example.springproject.Controller;

import com.example.springproject.Entity.Enseignant;
import com.example.springproject.Service.IEnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Enseignant")
public class EnseignantController {
    @Autowired
    private IEnseignantService EnseignantService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Enseignant> getEnseignants(){
        List<Enseignant> listEns = EnseignantService.findAll();
        return listEns;
    }

    @PostMapping("/addEnseignant")
    @ResponseBody
    public Enseignant ajouterEnseignant(@RequestBody Enseignant enseignant) {
        int Enseignant = EnseignantService.ajouterEnseignant(enseignant);
        return enseignant;
    }

    @DeleteMapping("/removeEnseignant/{Enseignant-id}")
    @ResponseBody
    public void removeEnseignant(@PathVariable("Enseignant-id") Enseignant enseignant) {

        EnseignantService.deleteEnseignant(enseignant);
    }

    @GetMapping("/retrieveEnseignant/{Enseignant-id}")
    @ResponseBody
    public Enseignant retrieveEnseignant(@PathVariable("Enseignant-id") Integer enseignant) {
        return EnseignantService.findById(enseignant);
    }

    @PutMapping("/modifyEnseignant")
    @ResponseBody
    public Enseignant updateEnseignant(@RequestBody Enseignant enseignant) {
        Boolean Enseignant = EnseignantService.updateEnseignant(enseignant);
        return enseignant;
    }
}
