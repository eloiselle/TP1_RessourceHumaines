package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recruteur_interne")
public class RecruteurInterne extends Recruteur {
    
    @Id
    @Column(name = "id_recruteur_interne")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    
}
