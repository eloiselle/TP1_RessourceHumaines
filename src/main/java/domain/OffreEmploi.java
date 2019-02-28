package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offre_emploi")
public class OffreEmploi {
    
    @Id
    @Column(name = "id_offre_emploi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "date_parution") private String dateParution;
    public String getDateParution()                  { return dateParution; }
    public void setDateParution(String dateParution) { this.dateParution = dateParution; }
    
    @Column(name = "date_fin") private String dateFin;
    public String getDateFin()             { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    
    @Column(name = "nbr_postes") private int nbrPostes;
    public int getNbrPostes()               { return nbrPostes; }
    public void setNbrPostes(int nbrPostes) { this.nbrPostes = nbrPostes; }
    
    @Column(name = "salaire_offert") private float salaireOffert;
    public float getSalaireOffert()                   { return salaireOffert; }
    public void setSalaireOffert(float salaireOffert) { this.salaireOffert = salaireOffert; }
    
    @ManyToOne
    @JoinColumn(name = "id_emploi", insertable = false)
    private Emploi emploi;
    public Emploi getEmploi()            { return emploi; }
    public void setEmploi(Emploi emploi) { this.emploi = emploi; }
    
    @ManyToOne
    @JoinColumn(name = "id_etat_offre_emploi", insertable = false)
    private EtatOffreEmploi etatOffreEmploi;
    public EtatOffreEmploi getEtatOffreEmploi()                     { return etatOffreEmploi; }
    public void setEtatOffreEmploi(EtatOffreEmploi etatOffreEmploi) { this.etatOffreEmploi = etatOffreEmploi; }
    
    @ManyToOne
    @JoinColumn(name = "id_recruteur_interne", insertable = false)
    private Recruteur recruteurInterne;
    public Recruteur getRecruteurInterne()                      { return recruteurInterne; }
    public void setRecruteurInterne(Recruteur recruteurInterne) { this.recruteurInterne = recruteurInterne; }
    
    @ManyToOne
    @JoinColumn(name = "id_recruteur_externe", insertable = false)
    private Recruteur recruteurExterne;
    public Recruteur getRecruteurExterne()                      { return recruteurExterne; }
    public void setRecruteurExterne(Recruteur recruteurExterne) { this.recruteurExterne = recruteurExterne; }
    
    
    public OffreEmploi()                                        { }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffreEmploi that = (OffreEmploi) o;
        return id == that.id && nbrPostes == that.nbrPostes && Float.compare(that.salaireOffert, salaireOffert) == 0 && Objects.equals(dateParution, that.dateParution) && Objects.equals(dateFin, that.dateFin) && Objects.equals(emploi, that.emploi) && Objects.equals(etatOffreEmploi, that.etatOffreEmploi) && Objects.equals(recruteurInterne, that.recruteurInterne) && Objects.equals(recruteurExterne, that.recruteurExterne);
    }
    @Override
    public int hashCode() { return Objects.hash(id, dateParution, dateFin, nbrPostes, salaireOffert, emploi, etatOffreEmploi, recruteurInterne, recruteurExterne); }
    
    @Override
    public String toString() {
        
        return "OffreEmploi{" + "id=" + id + ", dateParution='" + dateParution + '\'' + ", dateFin='" + dateFin + '\'' + ", nbrPostes=" + nbrPostes + ", salaireOffert=" + salaireOffert + ", emploi=" + emploi + ", etatOffreEmploi=" + etatOffreEmploi + ", recruteurInterne=" + recruteurInterne + ", recruteurExterne=" + recruteurExterne + '}';
    }
}
