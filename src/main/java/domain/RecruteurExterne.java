package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "recruteur_externe")
public class RecruteurExterne extends Recruteur {
    
    @Id private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    

    
    
}
