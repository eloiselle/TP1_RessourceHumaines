package domain;

import javax.persistence.*;

@Entity
@Table(name = "emploi")
public class Emploi {
    
    @Id
    @Column(name = "id_emploi")
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
    
}
