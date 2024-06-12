package tn.iit.gestionimpression.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agents_tirage")
public class AgentTirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @Column
    private String email;

    @Column
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "agentTirage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DemandeTirage> demandesTirage;

    @ManyToOne
    @JoinColumn(name = "administrateur_id")
    private Administrateur administrateur;

    @Override
    public String toString() {
        return "AgentTirage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", role=" + role +
                ", active=" + active +
                // don't include demandesTirage in the toString method
                '}';
    }
}