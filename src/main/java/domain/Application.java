package domain;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @Column(name = "id_application")
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
}
