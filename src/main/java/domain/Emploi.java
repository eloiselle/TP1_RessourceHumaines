package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emploi")
public class Emploi {
    
    @Id
    @Column(name = "id_emploi")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "titre")
    private String titre;
    public String getTitre()           { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
}
