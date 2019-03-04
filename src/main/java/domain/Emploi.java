package domain;

import javax.persistence.*;
import java.util.Objects;

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
    public TypeEmploi getTypeEmploi()        { return typeEmploi; }
    public void setTypeEmploi(TypeEmploi typeEmploi) { this.typeEmploi = typeEmploi; }
    
    @ManyToOne
    @JoinColumn(name = "competence_required", insertable = false)
    private CompetenceRequired competenceRequired;
    public CompetenceRequired getCompetenceRequired()                   { return competenceRequired; }
    public void setCompetenceRequired( CompetenceRequired competenceRequired) { this.competenceRequired= competenceRequired; }
    
    // ************************************************************************
    
    public Emploi() {            }
    
    public Emploi(int id, String titre, String description, TypeEmploi typeEmploi) {
        
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.typeEmploi = typeEmploi;
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
