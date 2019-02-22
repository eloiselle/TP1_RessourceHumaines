package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "candidat")
public class Candidat {
    
    @Id
    @Column(name = "id_candidat")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "nom")
    String nom;
    public String getNom()         { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    @Column(name = "prenom")
    String prenom;
    public String getPrenom()            { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    @Column(name = "telephone")
    BigInteger telephone;
    public BigInteger getTelephone()               { return telephone; }
    public void setTelephone(BigInteger telephone) { this.telephone = telephone; }
    
    @Column(name = "email")
    String email;
    public String getEmail()           { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Column(name = "date_naissance")
    String dateNaissance;
    public String getDateNaissance()                   { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }

    @Column(name = "nas")
    BigInteger NAS;
    public BigInteger getNAS()         { return NAS; }
    public void setNAS(BigInteger NAS) { this.NAS = NAS; }
    
}
