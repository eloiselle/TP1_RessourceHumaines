package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;
import java.util.Objects;

public class Recruteur {
    
    @Id
    @Column(name = "id_recruteur")
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
    
    @Column(name = "commission") private float commission;
    public float getCommission()                { return commission; }
    public void setCommission(float commission) { this.commission = commission; }
    
    @Column(name = "nas") private BigInteger nas;
    public BigInteger getNas()         { return nas; }
    public void setNas(BigInteger nas) { this.nas = nas; }
    
    
    @ManyToOne
    @JoinColumn(name = "id_entreprise", insertable = false)
    private Entreprise entreprise;
    public Entreprise getcertification()             { return entreprise; }
    public void setEntreprise(Entreprise entreprise) { this.entreprise = entreprise; }
    
    public Recruteur()                               { }
    
    public Recruteur(int id, String nom, String prenom, BigInteger telephone, String email, float commission, BigInteger nas, Entreprise entreprise) {
        
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.commission = commission;
        this.nas = nas;
        this.entreprise = entreprise;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruteur recruteur = (Recruteur) o;
        return id == recruteur.id && Float.compare(recruteur.commission, commission) == 0 && Objects.equals(nom, recruteur.nom) && Objects.equals(prenom, recruteur.prenom) && Objects.equals(telephone, recruteur.telephone) && Objects.equals(email, recruteur.email) && Objects.equals(nas, recruteur.nas) && Objects.equals(entreprise, recruteur.entreprise);
    }
    @Override
    public int hashCode() { return Objects.hash(id, nom, prenom, telephone, email, commission, nas, entreprise); }
    
    @Override
    public String toString() {
        
        return "Recruteur{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", telephone=" + telephone + ", email='" + email + '\'' + ", commission=" + commission + ", nas=" + nas + ", entreprise=" + entreprise + '}';
    }
}
