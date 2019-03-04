package fr.univ.lorraine.houseSkipper.controller;

import fr.univ.lorraine.houseSkipper.model.Commentaire;
import fr.univ.lorraine.houseSkipper.model.Phase;
import fr.univ.lorraine.houseSkipper.model.Task;
import fr.univ.lorraine.houseSkipper.repositories.CommentairesRepository;
import fr.univ.lorraine.houseSkipper.repositories.PhaseRepository;
import fr.univ.lorraine.houseSkipper.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentaireController {

    @Autowired
    CommentairesRepository commentairesRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    PhaseRepository phaseRepository;

    @PostMapping("commentaire/{id}")
    public Commentaire addComment(@PathVariable String id, @RequestParam("commentaire") Commentaire commentaire){
        Task task = this.taskRepository.findByNom(id).get(0);
        Phase phase = this.phaseRepository.findByPhaseName(task.getCurrentPhase());
        System.out.println("tskBudget : !!!!-----------------" + task.getPartiesExacte().size());
        commentaire.setTask(task);
        commentaire.setPhase(phase);
        return commentairesRepository.save(commentaire);
    }
}