package tn.iit.gestionimpression.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupes")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int numberOfStudents;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matiere> matieres;

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                // don't include enseignant in the toString method
                '}';
    }
}