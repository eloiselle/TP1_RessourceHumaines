package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offre_emploi")
public class OffreEmploi {
    
    @Id
    @Column(name = "id_offre_emploi")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "date_parution")
    private String dateParution;
    public String getDateParution()                  { return dateParution; }
    public void setDateParution(String dateParution) { this.dateParution = dateParution; }
    
    @Column(name = "date_fin")
    private String dateFin;
    public String getDateFin()             { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    
    @Column(name = "nbr_postes")
    private int nbrPostes;
    public int getNbrPostes()               { return nbrPostes; }
    public void setNbrPostes(int nbrPostes) { this.nbrPostes = nbrPostes; }
    
    @Column(name = "salaire_offert")
    private float salaireOffert;
    public float getSalaireOffert()                   { return salaireOffert; }
    public void setSalaireOffert(float salaireOffert) { this.salaireOffert = salaireOffert; }
    
    
}
