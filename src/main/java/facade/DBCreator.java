package facade;

import academy.*;
import domain.*;

import java.math.BigInteger;

public class DBCreator {
    
    public static void main(String[] args) throws Exception{ new DBCreator().run(); }
    
    
    public void run() throws Exception {
    
        RHModel.init();
    
        generateData();
        
        RHModel.close();
    
    }
    
    public void generateData(){
        
    
        Candidat candidat = new Candidat();
        candidat.setPrenom("Anthony");
        candidat.setNom("Cote");
        candidat.setDateNaissance("1986-11-24");
        candidat.setEmail("coteanthony0@gmail.com");
        candidat.setNAS(BigInteger.valueOf(123456789));
        candidat.setTelephone(BigInteger.valueOf(1892448451));
        RHModel.ajouteCandidat(candidat);
    
        Application application = new Application();
        application.setCvPath("/home/rh/cv/coteanthony20180303.doc");
        RHModel.create(application);
    
        Competence competence = new Competence();
        competence.setName("Java");
        competence.setDescription("Programmation OOP avec Java");
        RHModel.create(competence);
    
        Emploi emploi = new Emploi();
        emploi.setTitre("Programmeur");
        RHModel.create(emploi);
    
        Entreprise entreprise = new Entreprise();
        entreprise.setName("CGI");
        entreprise.setDescription("Entreprise de sherbrooke");
        RHModel.create(entreprise);
    
        EtatOffreEmploi etatOffreEmploi = new EtatOffreEmploi();
        etatOffreEmploi.setName("Recherche");
        etatOffreEmploi.setDescription("L'entreprise recherche activement des candidat");
        RHModel.create(etatOffreEmploi);
    
        OffreEmploi offreEmploi = new OffreEmploi();
        offreEmploi.setDateParution("2019-02-02");
        offreEmploi.setDateFin("2019-03-03");
        offreEmploi.setSalaireOffert(20);
        offreEmploi.setNbrPostes(2);
        RHModel.create(offreEmploi);
    
        RecruteurExterne recruteurExterne = new RecruteurExterne();
        recruteurExterne.setPrenom("Bob");
        recruteurExterne.setNom("Roberts");
        recruteurExterne.setTelephone(BigInteger.valueOf(123456789));
        recruteurExterne.setEmail("bob@cgi.com");
        RHModel.create(recruteurExterne);
    
    
        RecruteurInterne recruteurInterne = new RecruteurInterne();
        recruteurInterne.setPrenom("Alice");
        recruteurInterne.setNom("Merveille");
        recruteurInterne.setTelephone(BigInteger.valueOf(1895554321));
        recruteurInterne.setEmail("alice@rh.com");
        recruteurInterne.setNas(BigInteger.valueOf(123456789));
        recruteurInterne.setCommission(12);
        RHModel.create(recruteurInterne);
    
        TypeCertification typeCertification = new TypeCertification();
        typeCertification.setName("DEC en Informatique de gestion");
        typeCertification.setDescription("Programmation, Base de donnee, Interface graphique");
        RHModel.create(typeCertification);
    
        TypeEmploi typeEmploi = new TypeEmploi();
        typeEmploi.setName("Informatique");
        typeEmploi.setDescription("Emploi relie au domaine de l'informatique");
        RHModel.create(typeEmploi);
    
    }
        
        
        
    public void obsolete(){
//
//        etudiant = RHModel.loadEtudiant(1);
//
//        etudiant.setPrenom("Anthony");
//        etudiant.setNom("Cote");
//        RHModel.update(etudiant);
//        etudiant = RHModel.loadEtudiant(1);
//
//        etudiant.setId(2);
//        RHModel.update(etudiant);
//
//
//
//
//        Cours cours = new Cours(v101, prof[0], "H18");
//        Cours cours2 = new Cours(v102, prof[1], "A18");
//        Cours cours3 = new Cours(t101, prof[2], "A19");
//        Cours cours4 = new Cours(t102, prof[3], "H19");
//        Cours cours5 = new Cours(t101, prof[4], "A20");
//
//        Inscription inscription = new Inscription();
//        inscription.setEtudiant(etu[0]);
//        inscription.setDate("2016-08-21");
//        inscription.setEtat(1);
//
//
//        RHModel.create(inscription);
//        inscription = RHModel.annulerInscription(inscription);
//
//
//
//        RHModel.supprimerProfesseur(prof[2]);
//
//
//
//        // Cours (composite primary key)
//        RHModel.ajouterCours(cours, false);
//        cours.setCurriculum(v102);
//        RHModel.changerCours(cours);
//
//        RHModel.ajouterCours(cours2, false);
//        cours2.setProfesseur(prof[2]);
//        RHModel.changerCours(cours2);
//
//
//        RHModel.ajouterCours(cours3, false);
//        RHModel.ajouterCours(cours4, false);
//        RHModel.ajouterCours(cours5, false);
//
        
    }
    
    
    
}
