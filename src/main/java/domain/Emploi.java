package domain;

import facade.RHModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "emploi")
public class Emploi {
    
    @Id
    @Column(name = "id_emploi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "titre") private String titre;
    public String getTitre()           { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    
    @Column(name = "description") String description;
    public String getDescription()                 { return description; }
    public void setDescription(String description) { this.description = description; }
    
    
    @ManyToOne
    @JoinColumn(name = "id_type_emploi", insertable = false)
    private TypeEmploi typeEmploi;
    public TypeEmploi getTypeEmploi()                { return typeEmploi; }
    public void setTypeEmploi(TypeEmploi typeEmploi) { this.typeEmploi = typeEmploi; }
    
    @OneToMany(mappedBy = "id_emploi") private Set <CompetenceRequired> competenceRequireds = new HashSet <>();
    public Set <CompetenceRequired> getCompetenceRequireds()                         { return competenceRequireds; }
    public void setCompetenceRequireds(Set <CompetenceRequired> competenceRequireds) { this.competenceRequireds = competenceRequireds; }
    // ************************************************************************
    
    public Emploi()             { }
    
    public Emploi(String titre) { this.titre = titre; }
    
    public Emploi(int id, String titre, String description, TypeEmploi typeEmploi) {
        
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.typeEmploi = typeEmploi;
    }
    
    /**
     Cree une Competence acquired pour le candidat
     @param competence Competence
     @param level      Niveau de competence
     */
    public void requiereCompetence(Competence competence, int level) {
        
        CompetenceRequired ca = new CompetenceRequired(this, competence, level);
        competenceRequireds.add(ca);
        RHModel.create(ca);
    }
    
    
    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploi emploi = (Emploi) o;
        return id == emploi.id && Objects.equals(titre, emploi.titre) && Objects.equals(description, emploi.description) && Objects.equals(typeEmploi, emploi.typeEmploi);
    }
    @Override
    public int hashCode() { return Objects.hash(id, titre, description, typeEmploi); }
    
    @Override
    public String toString() {
        
        return "Emploi{" + "id=" + id + ", titre='" + titre + '\'' + ", description='" + description + '\'' + ", typeEmploi=" + typeEmploi + '}';
    }
}
