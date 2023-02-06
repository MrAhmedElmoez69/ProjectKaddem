package com.example.springproject.Controller;

import com.example.springproject.Entity.Universite;
import com.example.springproject.Service.IUniversiteService;
import com.example.springproject.Service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteController {
    @Autowired
    private IUniversiteService universiteService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Universite> getUniversites() {
        List<Universite> listUniv = universiteService.findAll();
        return listUniv;
    }

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite ajouterUniversite(@RequestBody Universite u) {
        int Universite = universiteService.ajouterUniversite(u);
        return u;
    }

    @DeleteMapping("/removeUniversite/{Universite-id}")
    @ResponseBody
    public void removeUniversite(@PathVariable("Universite-id") Universite u) {

        universiteService.deleteUniversite(u);
    }

    @GetMapping("/retrieveUniversite/{Universite-id}")
    @ResponseBody
    public Universite retrieveContart(@PathVariable("Universite-id") Integer u) {
        return universiteService.findById(u);
    }

    @PutMapping("/modifyUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite u) {
        Boolean Universite = universiteService.updateUniversite(u);
        return u;
    }


    @PostMapping("/adddeptouni/{uniId}/{depId}")
    @ResponseBody
    public void assignUniversiteToDepartement(@PathVariable("uniId") Integer uniId,@PathVariable("depId") Integer depId) {

        universiteService.update_uni_dep(uniId,depId);
    }




}
