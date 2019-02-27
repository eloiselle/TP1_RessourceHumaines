package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "competence")
public class Competence {
    
    @Id
    @Column(name = "id_competence")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "name") String name;
    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }
    
    @Column(name = "description") String description;
    public String getDescription()                 { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @ManyToOne
    @JoinColumn(name = "id_certification", insertable = false)
    private Certification certification;
    public Certification getCertification()                   { return certification; }
    public void setCertification(Certification certification) { this.certification = certification; }
    
    public Competence()                                       { }
    
    public Competence(int id, String name, String description, Certification certification) {
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.certification = certification;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(certification, that.certification);
    }
    @Override
    public int hashCode() { return Objects.hash(id, name, description, certification); }
    
    @Override
    public String toString() {
        
        return "Competence{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", certification=" + certification + '}';
    }
}
