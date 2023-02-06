package com.example.springproject.Controller;

import com.example.springproject.Entity.DetailEquipe;
import com.example.springproject.Service.IDetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DetailEquipe")
public class DetailEquipeController {
    @Autowired
    private IDetailEquipeService DetailEquipeService;

    @GetMapping("/findall")
    @ResponseBody
    public List<DetailEquipe> getEquipes() {
        List<DetailEquipe> listDetailEquipe = DetailEquipeService.findAll();
        return listDetailEquipe;
    }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe ajouterEquipe(@RequestBody DetailEquipe de) {
        int DetailEquipe = DetailEquipeService.ajouterDetailEquipe(de);
        return de;
    }

    @DeleteMapping("/removeDetailEquipe/{DetailEquipe-id}")
    @ResponseBody
    public void removeDetailEquipe(@PathVariable("DetailEquipe-id") DetailEquipe de) {

        DetailEquipeService.deleteDetailEquipe(de);
    }

    @GetMapping("/retrieveDetailEquipe/{DetailEquipe-id}")
    @ResponseBody
    public DetailEquipe retrieveContart(@PathVariable("DetailEquipe-id") Integer de) {
        return DetailEquipeService.findById(de);
    }

    @PutMapping("/modifyDetailEquipe")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe de) {
        Boolean DetailEquipe = DetailEquipeService.updateDetailEquipe(de);
        return de;
    }
}
