package com.example.springproject.Service;

import com.example.springproject.Entity.*;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EquipeRepository;
import com.example.springproject.Repository.DepartementRepository;
import com.example.springproject.Repository.EtudiantRepository;
import com.example.springproject.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class EtudiantService implements IEtudiantService {
    @Autowired
    private EtudiantRepository EtudiantRepository;
    @Autowired
  private EquipeRepository equipeRepository;
  @Autowired
  private DepartementRepository DepartementRepository;
  @Autowired
    private ContratRepository contratRepository;

  @Override
  public int ajouterEtudiant(Etudiant C) {
    EtudiantRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteEtudiant(Etudiant C) {
    EtudiantRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateEtudiant(Etudiant C) {
    EtudiantRepository.save(C);
    return  EtudiantRepository.findById((Integer) C.getIdEtudaint()).equals(C);
  }

  @Override
  public List<Etudiant> findAll() {
    return (List<Etudiant>) EtudiantRepository.findAll();
  }

  @Override
  public Etudiant findById(Integer U) {
    return EtudiantRepository.findById(U).get();
  }

  @Override
  public List<Etudiant> getEtudiantsByDepartement(Integer idDepart) {
    return EtudiantRepository.findEtudiantByDepartement(idDepart);
  }
  @Transactional
  @Override
  public void updateStudent(Integer studentId, Integer depId)
  {
    Etudiant e=EtudiantRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("studenbt doesnt exist"));
    Departement d= DepartementRepository.findById(depId).orElseThrow(() -> new IllegalStateException("dep doesnt exist"));
    e.setDepartement(d);



  }

  @Transactional
  public void addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
    Contrat contrat = contratRepository.findById(idContrat).get();
    Equipe equipe = equipeRepository.findById(idEquipe).get();
    e.getContratList().add(contrat);
    e.getEquipes().add(equipe);
//    EtudiantRepository.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    EtudiantRepository.save(e);
    //etudiantRepository.save(contrat);
    System.out.println(e.getContratList());

  }


}
