//package reference_code;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "cours")
//@IdClass(CompetenceRequiredId.class)
//public class CompetenceRequired implements Serializable {
//
//
//    @JoinColumn(name = "id_curriculum")
//    @Column(insertable = false, updatable = false)
//    private int id_curriculum;
//    public int getId_emploi()                   { return id_curriculum; }
//    public void setId_emploi(int id_curriculum) { this.id_curriculum = id_curriculum; }
//
//
//    @JoinColumn(name = "id_professeur")
//    @Column(insertable = false, updatable = false)
//    private int id_professeur;
//    public int getId_competence()                   { return id_professeur; }
//    public void setId_competence(int id_professeur) { this.id_professeur = id_professeur; }
//
//    @ManyToOne
//    @JoinColumn(name = "id_curriculum", insertable = false)
//    private Curriculum curriculum;
//    public Curriculum getCandidat() { return curriculum; }
//    public void setCandidat(Curriculum curriculum) {
//        this.curriculum = curriculum;
//        id_curriculum = curriculum.getId();
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_professeur", insertable = false)
//    private Professeur professeur;
//    public Professeur getCompetence() { return professeur; }
//    public void setCompetence(Professeur professeur) {
//        this.professeur = professeur;
//        id_professeur = professeur.getId();
//    }
//
//
//    @Id
//    @Column(name = "term")
//    private String term; // Ex : "H18", "A19", "E19"
//    public String getLevel() { return term; }
//    public void setLevel(String term) { this.term = term; }
//
//
//    //*****************************************************
//
//
//    public CompetenceRequired() {
//
//        this.curriculum = new Curriculum();
//        this.professeur = new Professeur();
//        this.term = "H18";
//    }
//
//    public CompetenceRequired(Curriculum curriculum, Professeur professeur, String term) {
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
//        CompetenceRequired cours = (CompetenceRequired) o;
//        return getId_emploi() == cours.getId_emploi() && getId_competence()== cours.getId_competence()&& Objects.equals(term, cours.term);
//    }
//
//    @Override
//    public int hashCode() { return Objects.hash(getId_emploi(), getId_competence(), term); }
//
//    @Override
//    public String toString() {
//
//        return "CompetenceRequired{" + "id_term=" + term + ", id_curriculum=" + curriculum + ", id_professeur=" + professeur + '}';
//    }
//}
