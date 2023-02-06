package com.example.springproject.Controller;

import com.example.springproject.Entity.Equipe;
import com.example.springproject.Service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    private IEquipeService EquipeService;

    @GetMapping("/findall")
    @ResponseBody
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipe = EquipeService.findAll();
        return listEquipe;
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe ajouterEquipe(@RequestBody Equipe e) {
        int Equipe = EquipeService.ajouterEquipe(e);
        return e;
    }

    @DeleteMapping("/removeEquipe/{Equipe-id}")
    @ResponseBody
    public void removeEquipe(@PathVariable("Equipe-id") Equipe e) {

        EquipeService.deleteEquipe(e);
    }

    @GetMapping("/retrieveEquipe/{Equipe-id}")
    @ResponseBody
    public Equipe retrieveContart(@PathVariable("Equipe-id") Integer c) {
        return EquipeService.findById(c);
    }

    @PutMapping("/modifyEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe e) {
        Boolean Equipe = EquipeService.updateEquipe(e);
        return e;
    }
}
