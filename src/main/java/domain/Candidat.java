package domain;

import facade.RHModel;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "candidat")
public class Candidat {
    
    @Id
    @Column(name = "id_candidat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "nom") private String nom;
    public String getNom()         { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    @Column(name = "prenom") private String prenom;
    public String getPrenom()            { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    @Column(name = "telephone") private BigInteger telephone;
    public BigInteger getTelephone()               { return telephone; }
    public void setTelephone(BigInteger telephone) { this.telephone = telephone; }
    
    @Column(name = "email") private String email;
    public String getEmail()           { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Column(name = "date_naissance") private String dateNaissance;
    public String getDateNaissance()                   { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    
    @Column(name = "nas") private BigInteger NAS;
    public BigInteger getNAS()         { return NAS; }
    public void setNAS(BigInteger NAS) { this.NAS = NAS; }
    
    @OneToMany(mappedBy = "id_candidat") private Set <CompetenceAcquired> competenceAcquireds = new HashSet <>();
    public Set <CompetenceAcquired> getCompetenceAcquireds()                         { return competenceAcquireds; }
    public void setCompetenceAcquireds(Set <CompetenceAcquired> competenceAcquireds) { this.competenceAcquireds = competenceAcquireds; }
    
    // ************************************************************************
    
    public Candidat() { }
    
    public Candidat(String nom, String prenom) {
        
        this.nom = nom;
        this.prenom = prenom;
    }
    public Candidat(int id, String nom, String prenom, BigInteger telephone, String email, String dateNaissance, BigInteger NAS) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.NAS = NAS;
    }
    
    /**
     Cree une Competence acquired pour le candidat
     @param competence Competence
     @param level      Niveau de competence
     */
    public void earnCompetence(Competence competence, int level) {
        
        CompetenceAcquired ca = new CompetenceAcquired(this, competence, level);
        competenceAcquireds.add(ca);
        RHModel.create(ca);
    }
    
    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return id == candidat.id && Objects.equals(nom, candidat.nom) && Objects.equals(prenom, candidat.prenom) && Objects.equals(telephone, candidat.telephone) && Objects.equals(email, candidat.email) && Objects.equals(dateNaissance, candidat.dateNaissance) && Objects.equals(NAS, candidat.NAS);
    }
    @Override
    public int hashCode() { return Objects.hash(id, nom, prenom, telephone, email, dateNaissance, NAS); }
    
    @Override
    public String toString() {
        
        return "Candidat{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", telephone=" + telephone + ", email='" + email + '\'' + ", dateNaissance='" + dateNaissance + '\'' + ", NAS=" + NAS + '}';
    }
}
