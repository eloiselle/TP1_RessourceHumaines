package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "recruteur_interne")
public class RecruteurInterne extends Recruteur {
    
    @Id
    @Column(name = "id_recruteur_interne")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "commission")
    private float commission;
    public float getCommission()                { return commission; }
    public void setCommission(float commission) { this.commission = commission; }
    
    @Column(name = "nas")
    private BigInteger nas;
    public BigInteger getNas()         { return nas; }
    public void setNas(BigInteger nas) { this.nas = nas; }
    
}
