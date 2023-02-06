package com.example.springproject.Controller;


import com.example.springproject.Entity.Paiement;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Service.IPaiementService;
import com.example.springproject.Service.PaiementService;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Paiement")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Paiement> getPaiements(){
        List<Paiement> listPai = paiementService.findAll();
        return listPai;
    }

    @PostMapping("/addPaiement")
    @ResponseBody
    public Paiement ajouterPaiement(@RequestBody Map<String, String> json) {
        int mnt  = Integer.parseInt(json.get("mnt"));
        int idE  = Integer.parseInt(json.get("idE"));
        int idC  = Integer.parseInt(json.get("idC"));



        Paiement paiement = paiementService.ajouterPaiement(mnt , idE , idC);
        return paiement;
    }

    @DeleteMapping("/removePaiement/{Paiement-id}")
    @ResponseBody
    public void removePaiement(@PathVariable("Paiement-id") Paiement p) {

        paiementService.deletePaiement(p);
    }

    @GetMapping("/retrievePaiement/{Paiement-id}")
    @ResponseBody
    public Paiement retrievePaiement(@PathVariable("Paiement-id") Integer p) {
        return paiementService.findById(p);
    }

    @PutMapping("/modifyPaiement")
    @ResponseBody
    public boolean updatePaiement(@RequestBody Map<String, String> json) {
        int idP  = Integer.parseInt(json.get("idP"));
        int mnt  = Integer.parseInt(json.get("mnt"));
        int idE  = Integer.parseInt(json.get("idE"));
        int idC  = Integer.parseInt(json.get("idC"));


        Boolean Paiement = paiementService.updatePaiement( idP ,  mnt ,  idE ,  idC);
        return true;
    }


}
