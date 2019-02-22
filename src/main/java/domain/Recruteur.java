package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;

public class Recruteur {
    
    @Id
    @Column(name = "id_recruteur")
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
    
    @Column(name = "telephone") BigInteger telephone;
    public BigInteger getTelephone()               { return telephone; }
    public void setTelephone(BigInteger telephone) { this.telephone = telephone; }
    
    @Column(name = "email")
    String email;
    public String getEmail()           { return email; }
    public void setEmail(String email) { this.email = email; }
    
}
