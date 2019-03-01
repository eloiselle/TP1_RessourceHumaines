//package reference_code;
//
//import java.io.Serializable;
//import java.util.Objects;
//
///** Cle primaire pour la classe CompetenceRequired*/
//public class CoursId implements Serializable {
//
//    private int id_curriculum;
//    private int id_professeur;
//
//    /** Constructeur */
//    public CoursId() {}
//
//    /** Constructeur de cle primaire composee
//     @param id_curriculum
//     @param id_professeur
//     */
//    public CoursId(int id_curriculum, int id_professeur) {
//
//        this.id_curriculum = id_curriculum;
//        this.id_professeur = id_professeur;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CoursId coursId = (CoursId) o;
//        return id_curriculum == coursId.id_curriculum && id_professeur == coursId.id_professeur;
//    }
//    @Override
//    public int hashCode() { return Objects.hash(id_curriculum, id_professeur); }
//}
