//package academy;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "cours")
//@IdClass(CoursId.class)
//public class Cours implements Serializable {
//
//
//    @JoinColumn(name = "id_curriculum")
//    @Column(insertable = false, updatable = false)
//    private int id_curriculum;
//    public int getId_curriculum()                   { return id_curriculum; }
//    public void setId_curriculum(int id_curriculum) { this.id_curriculum = id_curriculum; }
//
//
//    @JoinColumn(name = "id_professeur")
//    @Column(insertable = false, updatable = false)
//    private int id_professeur;
//    public int getId_professeur()                   { return id_professeur; }
//    public void setId_professeur(int id_professeur) { this.id_professeur = id_professeur; }
//
//    @ManyToOne
//    @JoinColumn(name = "id_curriculum", insertable = false)
//    private Curriculum curriculum;
//    public Curriculum getCurriculum() { return curriculum; }
//    public void setCurriculum(Curriculum curriculum) {
//        this.curriculum = curriculum;
//        id_curriculum = curriculum.getId();
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_professeur", insertable = false)
//    private Professeur professeur;
//    public Professeur getProfesseur() { return professeur; }
//    public void setProfesseur(Professeur professeur) {
//        this.professeur = professeur;
//        id_professeur = professeur.getId();
//    }
//
//
//    @Id
//    @Column(name = "term")
//    private String term; // Ex : "H18", "A19", "E19"
//    public String getTerm() { return term; }
//    public void setTerm(String term) { this.term = term; }
//
//
//    //*****************************************************
//
//
//    public Cours() {
//
//        this.curriculum = new Curriculum();
//        this.professeur = new Professeur();
//        this.term = "H18";
//    }
//
//    public Cours(Curriculum curriculum, Professeur professeur, String term) {
//
//        this.id_curriculum = curriculum.getId();
//        this.id_professeur = professeur.getId();
//        this.curriculum = curriculum;
//        this.professeur = professeur;
//        this.term = term;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cours cours = (Cours) o;
//        return getId_curriculum() == cours.getId_curriculum() && getId_professeur()== cours.getId_professeur()&& Objects.equals(term, cours.term);
//    }
//
//    @Override
//    public int hashCode() { return Objects.hash(getId_curriculum(), getId_professeur(), term); }
//
//    @Override
//    public String toString() {
//
//        return "Cours{" + "id_term=" + term + ", id_curriculum=" + curriculum + ", id_professeur=" + professeur + '}';
//    }
//}
