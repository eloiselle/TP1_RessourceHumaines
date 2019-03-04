package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @Column(name = "id_application")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    /** Path to the file for the CV of the candidate */
    @Column(name = "cv_path") String cvPath;
    public String getCvPath()            { return cvPath; }
    public void setCvPath(String cvPath) { this.cvPath = cvPath; }
    
    
    @Column(name = "date_application") String dateApplication;
    public String getDateApplication()                     { return dateApplication; }
    public void setDateApplication(String dateApplication) { this.dateApplication = dateApplication; }
    
    @Column(name = "date_entrevue") String dateEntrevue;
    public String getDateEntrevue()                  { return dateEntrevue; }
    public void setDateEntrevue(String dateEntrevue) { this.dateEntrevue = dateEntrevue; }
    
    @Column(name = "heure_entrevue") String heureEntrevue;
    public String getHeureEntrevue()                   { return heureEntrevue; }
    public void setHeureEntrevue(String heureEntrevue) { this.heureEntrevue = heureEntrevue; }
    
    @Column(name = "adresse_entrevue") String adresseEntrevue;
    public String getAdresseEntrevue()                     { return adresseEntrevue; }
    public void setAdresseEntrevue(String adresseEntrevue) { this.adresseEntrevue = adresseEntrevue; }
    
    @Column(name = "commentaire") String commentaire;
    public String getCommentaire()                 { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    
    @ManyToOne
    @JoinColumn(name = "id_candidat", insertable = false)
    private Candidat candidat;
    public Candidat getCandidat()              { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
    
    @ManyToOne
    @JoinColumn(name = "id_offre_emploi", insertable = false)
    private OffreEmploi offre_emploi;
    public OffreEmploi getOffreEmploi()                 { return offre_emploi; }
    public void setOffreEmploi(OffreEmploi offreEmploi) { this.offre_emploi = offreEmploi; }
    
    // ************************************************************************
    
    public Application() {           }
    
    public Application(int id, String cvPath, String dateApplication, String dateEntrevue, String heureEntrevue,
                       String adresseEntrevue, String commentaire, Candidat candidat, OffreEmploi offre_emploi) {
        
        this.id = id;
        this.cvPath = cvPath;
        this.dateApplication = dateApplication;
        this.dateEntrevue = dateEntrevue;
        this.heureEntrevue = heureEntrevue;
        this.adresseEntrevue = adresseEntrevue;
        this.commentaire = commentaire;
        this.candidat = candidat;
        this.offre_emploi = offre_emploi;
    }
    
    
    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id == that.id && Objects.equals(cvPath, that.cvPath) && Objects.equals(dateApplication, that.dateApplication) && Objects.equals(dateEntrevue, that.dateEntrevue) && Objects.equals(heureEntrevue, that.heureEntrevue) && Objects.equals(adresseEntrevue, that.adresseEntrevue) && Objects.equals(commentaire, that.commentaire) && Objects.equals(candidat, that.candidat) && Objects.equals(offre_emploi, that.offre_emploi);
    }
    @Override
    public int hashCode() {
        
        return Objects.hash(id, cvPath, dateApplication, dateEntrevue, heureEntrevue, adresseEntrevue, commentaire, candidat, offre_emploi);
    }
    @Override
    public String toString() {
        
        return "Application{" + "id=" + id + ", cvPath='" + cvPath + '\'' + ", dateApplication='" + dateApplication +
                '\'' + ", dateEntrevue='" + dateEntrevue + '\'' + ", heureEntrevue='" + heureEntrevue + '\'' +
                ", adresseEntrevue='" + adresseEntrevue + '\'' + ", commentaire='" + commentaire + '\'' + ", candidat=" +
                candidat + ", offre_emploi=" + offre_emploi + '}';
    }
}
