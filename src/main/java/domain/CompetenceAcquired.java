package domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ta_competence_acquired")
@IdClass(CompetenceAcquiredId.class)
public class CompetenceAcquired implements Serializable {


    @JoinColumn(name = "id_candidat")
    @Column(insertable = false, updatable = false)
    private int id_candidat;
    public int getId_candidat()                 { return id_candidat; }
    public void setId_candidat(int id_candidat) { this.id_candidat = id_candidat; }


    @JoinColumn(name = "id_competence")
    @Column(insertable = false, updatable = false)
    private int id_competence;
    public int getId_competence()                   { return id_competence; }
    public void setId_competence(int id_competence) { this.id_competence = id_competence; }

    @ManyToOne
    @JoinColumn(name = "id_candidat", insertable = false)
    private Candidat candidat;
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
        id_candidat = candidat.getId();
    }

    @ManyToOne
    @JoinColumn(name = "id_competence", insertable = false)
    private Competence competence;
    public Competence getCompetence() { return competence; }
    public void setCompetence(Competence competence) {
        this.competence = competence;
        id_competence = competence.getId();
    }


    @Id
    @Column(name = "level")
    private int level;
    public int getLevel()           { return level; }
    public void setLevel(int level) { this.level = level; }


    // ************************************************************************


    public CompetenceAcquired() {

        this.candidat = new Candidat();
        this.competence = new Competence();
        this.level = 0;
    }

    public CompetenceAcquired(Candidat candidat, Competence competence, int level) {

        this.id_candidat = candidat.getId();
        this.id_competence = competence.getId();
        this.candidat = candidat;
        this.competence = competence;
        this.level = level;
    }
    


    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceAcquired competenceAcquired = (CompetenceAcquired) o;
        return getId_candidat() == competenceAcquired.getId_candidat() && getId_competence()== competenceAcquired.getId_competence();
    }

    @Override
    public int hashCode() { return Objects.hash(getId_candidat(), getId_competence(), level); }
    
    @Override
    public String toString() {
        
        return "CompetenceAcquired{" + "id_candidat=" + id_candidat + ", id_competence=" + id_competence + ", candidat=" + candidat + ", competence=" + competence + ", level=" + level + '}';
    }
}
