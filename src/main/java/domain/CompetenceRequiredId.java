package domain;

import java.io.Serializable;
import java.util.Objects;

/** Cle primaire pour la classe CompetenceRequired*/
public class CompetenceRequiredId implements Serializable {
   
    private int id_emploi;
    private int id_competence;
    
    // ************************************************************************
    
    /** Constructeur */
    public CompetenceRequiredId() {}
    
    /** Constructeur de cle primaire composee
     @param id_emploi
     @param id_competence
     */
    public CompetenceRequiredId(int id_emploi, int id_competence) {
        
        this.id_emploi = id_emploi;
        this.id_competence = id_competence;
    }
    
    // ************************************************************************
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceRequiredId competenceRequiredId = (CompetenceRequiredId) o;
        return id_emploi == competenceRequiredId.id_emploi && id_competence == competenceRequiredId.id_competence;
    }
    @Override
    public int hashCode() { return Objects.hash(id_emploi, id_competence); }
}
