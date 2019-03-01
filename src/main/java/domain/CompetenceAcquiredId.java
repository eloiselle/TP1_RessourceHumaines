package domain;

import java.io.Serializable;
import java.util.Objects;

/** Cle primaire pour la classe CompetenceRequired*/
public class CompetenceAcquiredId implements Serializable {
   
    private int id_candidat;
    private int id_competence;
    
    /** Constructeur */
    public CompetenceAcquiredId() {}
    
    /** Constructeur de cle primaire composee
     @param id_candidat
     @param id_competence
     */
    public CompetenceAcquiredId(int id_candidat, int id_competence) {
        
        this.id_candidat = id_candidat;
        this.id_competence = id_competence;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceAcquiredId competenceAcquiredId = (CompetenceAcquiredId) o;
        return id_candidat == competenceAcquiredId.id_candidat && id_competence == competenceAcquiredId.id_competence;
    }
    @Override
    public int hashCode() { return Objects.hash(id_candidat, id_competence); }
}
