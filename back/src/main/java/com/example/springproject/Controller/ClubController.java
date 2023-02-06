package com.example.springproject.Controller;

import com.example.springproject.Entity.Club;
import com.example.springproject.Service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Club")
public class ClubController {
    @Autowired
    private IClubService ClubService;


    @GetMapping("/findall")
    @ResponseBody
    public List<Club> getClubs() {
        List<Club> listClub = ClubService.findAll();
        return listClub;
    }

    @PostMapping("/addClub")
    @ResponseBody
    public Club ajouterClub(@RequestBody Club c) {
        int Club = ClubService.ajouterClub(c);
        return c;
    }

    @DeleteMapping("/removeClub/{Club-id}")
    @ResponseBody
    public void removeClub(@PathVariable("Club-id") Club c) {

        ClubService.deleteClub(c);
    }

    @GetMapping("/retrieveClub/{Club-id}")
    @ResponseBody
    public Club retrieveContart(@PathVariable("Club-id") Integer c) {
        return ClubService.findById(c);
    }

    @PutMapping("/modifyClub")
    @ResponseBody
    public Club updateClub(@RequestBody Club c) {
        Boolean Club = ClubService.updateClub(c);
        return c;
    }
}
