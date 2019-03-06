package domain;

import utils.IdInterface;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "competence")
public class Competence  implements IdInterface {
    
    @Id
    @Column(name = "id_competence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "name") private String name;
    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }
    
    @Column(name = "description") private String description;
    public String getDescription()                 { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @ManyToOne
    @JoinColumn(name = "id_certification", insertable = false)
    private Certification certification;
    public Certification getCertification()                   { return certification; }
    public void setCertification(Certification certification) { this.certification = certification; }
    
//    @ManyToMany(mappedBy="competences")
//    private Set <Candidat> candidats = new HashSet <>();
//    public Set<Candidat> getCustomers() { return candidats; }
//    public void setCandidats(Set <Candidat> candidats) { this.candidats = candidats; }
    
    // ************************************************************************
    
    public Competence() { }
    
    public Competence(String name, String description) {
        
        this.name = name;
        this.description = description;
    }
    
    public Competence(int id, String name, String description, Certification certification) {
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.certification = certification;
    }
    
    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return id == that.id && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() { return Objects.hash(id, name, description); }
    
    @Override
    public String toString() {
        
        return "Competence{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", certification=" + certification + '}';
    }
}
