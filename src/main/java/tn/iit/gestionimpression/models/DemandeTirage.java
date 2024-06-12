package tn.iit.gestionimpression.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demandes_tirage")
public class DemandeTirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Enseignant enseignant;

    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private AgentTirage agentTirage;

    @Column
    private String document;

    @Column
    private int nombreCopies;

    @Column
    private boolean resolue = false;

    @Column
    private LocalDateTime dateHeureRetrait;

    @Override
    public String toString() {
        return "DemandeTirage{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", nombreCopies=" + nombreCopies +
                ", dateHeureRetrait=" + dateHeureRetrait +
                // don't include enseignant and matiere in the toString method
                '}';
    }
}