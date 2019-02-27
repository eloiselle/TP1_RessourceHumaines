package domain;

import javax.persistence.*;

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
    public Certification getcertification()                { return certification; }
    public void setProfesseur(Certification certification) { this.certification = certification; }
    
    
}
