package domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "candidat")
public class Candidat {
    
    @Id
    @Column(name = "id_candidat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "nom") String nom;
    public String getNom()         { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    @Column(name = "prenom") String prenom;
    public String getPrenom()            { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    @Column(name = "telephone") BigInteger telephone;
    public BigInteger getTelephone()               { return telephone; }
    public void setTelephone(BigInteger telephone) { this.telephone = telephone; }
    
    @Column(name = "email") String email;
    public String getEmail()           { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Column(name = "date_naissance") String dateNaissance;
    public String getDateNaissance()                   { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    
    @Column(name = "nas") BigInteger NAS;
    public BigInteger getNAS()         { return NAS; }
    public void setNAS(BigInteger NAS) { this.NAS = NAS; }
    
    @ManyToMany
    @JoinTable(name="ta_candidat_competence",
            joinColumns= @JoinColumn(name="id_candidat", referencedColumnName="id_candidat"),
            inverseJoinColumns= @JoinColumn(name="id_competence", referencedColumnName="id_competence"))
    private Set<Competence> competences = new HashSet <>();
    public Set<Competence> getCompetences()                  { return competences; }
    public void setCompetences(Set <Competence> competences) { this.competences = competences; }
    
    public Candidat() { }
    
    public Candidat(int id, String nom, String prenom, BigInteger telephone, String email, String dateNaissance, BigInteger NAS) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.NAS = NAS;
    }
    
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
