package com.example.springproject.Controller;

import com.example.springproject.Entity.Cours;
import com.example.springproject.Service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cours")
public class CoursController {
    @Autowired
    private ICoursService coursService;


    @GetMapping("/findall")
    @ResponseBody
    public List<Cours> getCourss() {
        List<Cours> listCours = coursService.findAll();
        return listCours;
    }

    @PostMapping("/addCours")
    @ResponseBody
    public Cours ajouterCours(@RequestBody Cours c) {
        int Cours = coursService.ajouterCours(c);
        return c;
    }

    @DeleteMapping("/removeCours/{Cours-id}")
    @ResponseBody
    public void removeCours(@PathVariable("Cours-id") Cours c) {

        coursService.deleteCours(c);
    }

    @GetMapping("/retrieveCours/{Cours-id}")
    @ResponseBody
    public Cours retrieveContart(@PathVariable("Cours-id") Integer c) {
        return coursService.findById(c);
    }

    @PostMapping("/modifyCours")
    @ResponseBody
    public Cours updateCours(@RequestBody Cours c) {
        Boolean Cours = coursService.updateCours(c);
        return c;
    }
}
