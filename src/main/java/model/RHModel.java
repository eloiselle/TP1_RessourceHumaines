package model;


import domain.*;
import utils.PersistenceManager;

import javax.persistence.EntityManager;


/**
 Classe statique pour les besoin du client
 Il est possible de juste utiliser PersistenceManager qui est generique
 RHModel permet de creer des methodes specifique */
public class RHModel extends PersistenceManager {
    
    /** Constructeur */
    public RHModel() throws ClassNotFoundException { init(); }
    
    
    /** Ajout un nouvel etudiant dans la database */
    public static boolean ajouteCandidat(Candidat c) { return create(c); }
    
    
    //
    //    /** Ajout un nouvel professeur dans la database */
    //    public static boolean ajouteProfesseur(Professeur p) { return create(p); }
    //
    //    /** Ajout un nouvel cours dans la database */
    //    public static boolean ajouterCours(CompetenceRequired c, boolean isCascading) {
    //
    //        if (isCascading) {
    //            update(c.getCandidat());
    //            update(c.getCompetence());
    //        }
    //        create(c);
    //        return true;
    //    }
    //
    //    /**     Modifi le cours
    //     @param c CompetenceRequired a mettre a jour
    //     @return si ca a reussi
    //     */
    //    public static CompetenceRequired changerCours(CompetenceRequired c) {
    //
    //        // Modifi les sous-elements
    //        c.setCandidat((Curriculum) update(c.getCandidat()));
    //        c.setCompetence((Professeur) update(c.getCompetence()));
    //
    //        return (CompetenceRequired) update(c);
    //    }
    //
    //    /**     Change l'etat de l'inscription pour la mettre a INACTIVE
    //     @param i incription a modifier
    //     @return si ca a reussi
    //     */
    //    public static Inscription annulerInscription(Inscription i) {
    //
    //        i.setEtat(Inscription.INACTIVE);
    //        return (Inscription) update(i);
    //    }
    //
    //    /**     Supprime un professeur de la base de donnees
    //     @param p le professeur a supprimer
    //     @return si ca a reussi
    //     */
    //    public static boolean supprimerProfesseur(Professeur p) {
    //
    //        return tryToDeleteProfesseur(p);
    //    }
    //
    //    /**     Load un etudiant a partir de la database
    //     @param id cle primaire
    //     @return objet Etudiant
    //     */
    public static Certification loadCertification(int id)     { return emFactory.createEntityManager().find(Certification.class, id); }
    public static Candidat loadCandidat(int id)               { return emFactory.createEntityManager().find(Candidat.class, id); }
    public static Competence loadCompetence(int id)           { return emFactory.createEntityManager().find(Competence.class, id); }
    public static Emploi loadEmploi(int id)                   { return emFactory.createEntityManager().find(Emploi.class, id); }
    public static Entreprise loadEntreprise(int id)           { return emFactory.createEntityManager().find(Entreprise.class, id); }
    public static EtatOffreEmploi loadEtatOffreEmploi(int id) { return emFactory.createEntityManager().find(EtatOffreEmploi.class, id); }
    public static Recruteur loadRecruteur(int id)             { return emFactory.createEntityManager().find(Recruteur.class, id); }
    public static TypeEmploi loadTypeEmploi(int id)           { return emFactory.createEntityManager().find(TypeEmploi.class, id); }
    //
    //    public static CompetenceRequired loadCours(int id_curriculum, int id_professeur) {
    //        return emFactory.createEntityManager().find(CompetenceRequired.class, new CompetenceRequiredId(id_curriculum,id_professeur));
    //    }
    //
    //    /** Verifie si ca existe dans la base de donnees
    //     @param id id de l'etudiant
    //     @return si l'etudiant existe dans la DB
    //     */
    //    public static boolean etudiantExist(int id) { return emFactory.createEntityManager().find(Etudiant.class, id) != null; }
    
    /** Essaye de supprimer un objet dans la DB */
    public static boolean delete(Certification obj) {
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        obj = em.find(Certification.class, ((Certification) obj).getId());
        em.remove(obj);
        
        return commit(em);
    }
    
        /** Essaye de supprimer un objet dans la DB */
    public static boolean delete(Competence obj) {
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        obj = em.find(Competence.class, ((Competence) obj).getId());
        em.remove(obj);
        
        return commit(em);
    }
}
