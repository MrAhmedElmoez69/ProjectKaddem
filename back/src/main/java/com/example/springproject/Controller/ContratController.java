package com.example.springproject.Controller;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
public class ContratController {
    @Autowired
    private IContratService ContratService;



    @GetMapping("/findall")
    @ResponseBody
    public List<Contrat> getContrats() {
        List<Contrat> listContrat = ContratService.findAll();
        return listContrat;
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat ajouterContrat(@RequestBody Contrat c) {
        int Contrat = ContratService.ajouterContrat(c);
        return c;
    }

    @DeleteMapping("/removeContrat/{contrat-id}")
    @ResponseBody
    public void removeContrat(@PathVariable("contrat-id") Contrat c) {

        ContratService.deleteContrat(c);
    }

    @GetMapping("/retrieveContrat/{contrat-id}")
    @ResponseBody
    public Contrat retrieveContart(@PathVariable("contrat-id") Integer c) {
        return ContratService.findById(c);
    }

    @PutMapping("/modifyContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat c) {
        Boolean Contrat = ContratService.updateContrat(c);
        return c;
    }

        @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
        float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
            return ContratService.getChiffreAffaireEntreDeuxDate(start,end);
        }



    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return ContratService.contratBetween2dates(start,end);
    }

    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratsValides(@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end ,@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start) {
        return ContratService.nbContratsValides(end,start) ;
    }

    @GetMapping("/contratExp/")
    List<Contrat> contratExp(){
        return ContratService.contratExp();
    }
    @GetMapping("/contratDepasseAn/")
    List<Contrat> contratDepasseAn(){
        return ContratService.contratDepasseAn();
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat ce,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE) {
        ContratService.affectContratToEtudiant(ce.getIdContrat(), nomE, prenomE);
        return ce;
    }
}
