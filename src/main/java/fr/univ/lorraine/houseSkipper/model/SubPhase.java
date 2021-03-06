package fr.univ.lorraine.houseSkipper.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="subPhase")
public class SubPhase {

    @Id @GeneratedValue
    private Long id;
    private String sPhaseName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "phase_sub")
    private @NonNull Phase phase;

    @OneToMany(mappedBy = "subPhase", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "histo_sPhase")
    private List<Historic> historics = new ArrayList<>();

    public SubPhase(){}

    public SubPhase(Long id, String sPhaseName){
        this.id = id;
        this.sPhaseName = sPhaseName;
    }
}
