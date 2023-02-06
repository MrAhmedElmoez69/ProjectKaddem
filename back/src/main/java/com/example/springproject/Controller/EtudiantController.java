package com.example.springproject.Controller;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    @Autowired
    private IEtudiantService EtudiantService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listetudiant = EtudiantService.findAll();
        return listetudiant;
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant ajouterEtudiant(@RequestBody Etudiant e) {
        int Etudiant = EtudiantService.ajouterEtudiant(e);
        return e;
    }

    @DeleteMapping("/removeEtudiant/{Etudiant-id}")
    @ResponseBody
    public void removeEtudiant(@PathVariable("Etudiant-id") Etudiant e) {
        EtudiantService.deleteEtudiant(e);
    }

    @GetMapping("/retrieveEtudiant/{Etudiant-id}")
    @ResponseBody
    public Etudiant retrieveContart(@PathVariable("Etudiant-id") Integer e) {
        return EtudiantService.findById(e);
    }

    @PutMapping("/modifyEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Boolean Etudiant = EtudiantService.updateEtudiant(e);
        return e;
    }

    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idequipe}")
    @ResponseBody
    public void addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant, @PathVariable("idContrat")Integer idContrat ,@PathVariable("idequipe") Integer idequipe ) {
        EtudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idequipe);
    }

    @GetMapping("/list/{idDepart}")
    List<Etudiant> retrieveAllEtudiants(@PathVariable("idDepart") Integer idDepart){
        return EtudiantService.getEtudiantsByDepartement(idDepart);
    }
    @PutMapping(path="affecttodep/{studentId}/{depId}")
    public void assignEtudiantToDepartement(@PathVariable("studentId") Integer studentId,@PathVariable("depId") Integer depId) throws IllegalStateException {

        EtudiantService.updateStudent(studentId,depId);
    }







}
