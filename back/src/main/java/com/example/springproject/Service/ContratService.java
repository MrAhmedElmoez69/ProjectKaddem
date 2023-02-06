package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Entity.Specialite;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ContratService implements IContratService {
    @Autowired
    private ContratRepository myRepository;
    private EtudiantRepository etudiantRepository;

    @Override
    public int ajouterContrat(Contrat C) {
        myRepository.save(C);
        return 1;
    }

    @Override
    public Boolean deleteContrat(Contrat C) {
        myRepository.delete(C);
        return true;
    }


    @Override
    public Boolean updateContrat(Contrat C) {
        myRepository.save(C);
        return  myRepository.findById((Integer) C.getIdContrat()).equals(C);
    }

    @Override
    public List<Contrat> findAll() {
        return (List<Contrat>) myRepository.findAll();
    }

    @Override
    public Contrat findById(Integer C) {
        return myRepository.findById(C).get();
    }


        @Override
        public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
            List<Contrat> listContrat=myRepository.contratBetween2dates(startDate,endDate);
            System.out.println(listContrat);
            float chiffre=0;
            for( Contrat c:listContrat){
                if(c.getSpecialite().equals(Specialite.IA)){
                    chiffre=chiffre+300;
                }
                else if (c.getSpecialite().equals(Specialite.RESEAU)){
                    chiffre=chiffre+350;
                }
                else if(c.getSpecialite().equals(Specialite.CLOUD)){
                    chiffre=chiffre+400;
                }
                else if (c.getSpecialite().equals(Specialite.SECURITE)){
                    chiffre=chiffre+450;
                }
            }
            return chiffre;
        }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  myRepository.contratBetween2dates(startDate,endDate);
    }
    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return myRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate).intValue();
    }

    @Override
    public List<Contrat> contratExp() {
         return myRepository.dateExpi();
    }
    
    public void setArchive(Contrat c){
        Contrat contrat = myRepository.findById(c.getIdContrat()).get();
        contrat.setArchive(true);
        myRepository.save(contrat);
    }

    @Scheduled(cron = "* * 1 * * * ")
    public void retrieveStatusContrat()
    {
        List<Contrat> contratsPresqueExp=myRepository.datePresqueExp();
        List<Contrat> contratsExp=myRepository.dateExpi();

        for (Contrat c : contratsExp) {
            setArchive(c);
        }

        StringBuilder string = new StringBuilder("contrats expirants dans les 15 jours suivants :");
        for (Contrat c : contratsPresqueExp){
            string.append("contrat id : ").append(c.getIdContrat()).append("\n");
            string.append("contrat debut date : ").append(c.getDateDebutContrat()).append("\n");
            string.append("contrat date fin : ").append(c.getDateFinContrat()).append("\n");
            string.append("specialité : ").append(c.getSpecialite()).append("\n");
        }
        log.info(string.toString());
    }

    @Override
    public List<Contrat> contratDepasseAn()
    {
        return myRepository.contratDepasseAn();
    }

    @Transactional
    public Contrat affectContratToEtudiant (int ce, String nomE,String prenomE){
        myRepository.X(ce,nomE,prenomE);
        return myRepository.findById(ce).get();
    }
}