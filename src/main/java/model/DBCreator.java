package model;

import domain.*;

import java.math.BigInteger;

public class DBCreator {
    
    public static void main(String[] args) throws Exception{ run(); }
    
    
    public static void run() throws Exception {
    
        RHModel.init();
        generateData();
        RHModel.close();
    }
    
    /** Generate data for the database */
    public static void generateData(){
        
        // TYPE
        
        TypeEmploi teManuel = new TypeEmploi();
        teManuel.setName("Manuel");
        teManuel.setDescription("Emploi manuel");
        RHModel.create(teManuel);
        
        TypeEmploi teInformatique = new TypeEmploi();
        teInformatique.setName("Informatique");
        teInformatique.setDescription("Emploi relie au domaine de l'informatique");
        RHModel.create(teInformatique);
        
        TypeEmploi teService = new TypeEmploi();
        teService.setName("Service");
        teService.setDescription("Emploi relie au domaine du service a la clientele");
        RHModel.create(teService);
        
        // ETAT
        
        EtatOffreEmploi eoeRecherche = new EtatOffreEmploi();
        eoeRecherche.setName("Recherche");
        eoeRecherche.setDescription("L'entreprise recherche activement des candidat");
        RHModel.create(eoeRecherche);
        
        EtatOffreEmploi eoeHired = new EtatOffreEmploi();
        eoeHired.setName("Hired");
        eoeHired.setDescription("Le poste a ete comble");
        RHModel.create(eoeHired);
        
        EtatOffreEmploi eoeNotFound = new EtatOffreEmploi();
        eoeNotFound.setName("Not_Satisfied");
        eoeNotFound.setDescription("L'entreprise n'a pas trouver ce quelle cherche");
        RHModel.create(eoeNotFound);
        
        EtatOffreEmploi eoeWaiting = new EtatOffreEmploi();
        eoeWaiting.setName("Waiting");
        eoeWaiting.setDescription("L'entreprise est en attente d'avancement");
        RHModel.create(eoeWaiting);
        
        EtatOffreEmploi eoeProcessing = new EtatOffreEmploi();
        eoeProcessing.setName("Processing");
        eoeProcessing.setDescription("L'entreprise est en train d'evaluer les candidats");
        RHModel.create(eoeProcessing);
        
        
        // Certification
        
        Certification certification = new Certification();
        certification.setName("DEC en Informatique de gestion");
        certification.setDescription("Programmation, Base de donnees, Interface graphique, ...");
        RHModel.create(certification);
    

        // Competences
        
        Competence cmpJava = new Competence();
        cmpJava.setName("Java");
        cmpJava.setDescription("Programmation OOP avec Java");
        cmpJava.setCertification(null);
        RHModel.create(cmpJava);
    
        Competence cmpJS = new Competence();
        cmpJS.setName("Javascript");
        cmpJS.setDescription("Programmation avec Javascript");
        cmpJS.setCertification(certification);
        RHModel.create(cmpJS);
        
        Competence cmpCpp = new Competence();
        cmpCpp.setName("C++");
        cmpCpp.setDescription("Programmation en C++ avec pointeurs");
        cmpCpp.setCertification(certification);
        RHModel.create(cmpCpp);
        
        // TEST DATA
    
        Candidat candidat = new Candidat();
        candidat.setPrenom("Anthony");
        candidat.setNom("Cote");
        candidat.setDateNaissance("1986-11-24");
        candidat.setEmail("coteanthony0@fakemail.com");
        candidat.setNAS(BigInteger.valueOf(123456789));
        candidat.setTelephone(BigInteger.valueOf(1892448451));
        RHModel.create(candidat);
        
        candidat.earnCompetence(cmpJava, 3);
        RHModel.update(candidat);
        

        Emploi emploi = new Emploi();
        emploi.setTitre("Programmeur");
        emploi.setDescription("Tapper au hasard sur un clavier jusqu'a ce que ca compile");
        emploi.setTypeEmploi(teInformatique);
        RHModel.create(emploi);
        
        emploi.requiereCompetence(cmpJS, 1);
        RHModel.update(emploi);
        
    
        Entreprise entreprise = new Entreprise();
        entreprise.setName("CGI");
        entreprise.setDescription("Entreprise de sherbrooke");
        RHModel.create(entreprise);
    

        Recruteur recruteur = new Recruteur();
        recruteur.setPrenom("Alice");
        recruteur.setNom("Merveille");
        recruteur.setTelephone(BigInteger.valueOf(1895554321));
        recruteur.setEmail("alice@rh.com");
        recruteur.setNas(BigInteger.valueOf(123456789));
        recruteur.setCommission(12);
        RHModel.create(recruteur);
    
        OffreEmploi offreEmploi = new OffreEmploi();
        offreEmploi.setDateParution("2019-02-02");
        offreEmploi.setDateFin("2019-03-03");
        offreEmploi.setSalaireOffert(20);
        offreEmploi.setNbrPostes(2);
        offreEmploi.setEmploi(emploi);
        offreEmploi.setEtatOffreEmploi(eoeProcessing);
        offreEmploi.setRecruteurInterne(recruteur);
        offreEmploi.setRecruteurExterne(recruteur);
        RHModel.create(offreEmploi);
    
        Application application = new Application();
        application.setCvPath("/home/rh/cv/coteanthony20180303.doc");
        application.setDateApplication("2019-02-02");
        application.setDateEntrevue("2019-03-03");
        application.setHeureEntrevue("13:15");
        application.setAdresseEntrevue("400 rue Marquette");
        application.setCommentaire("...");
        application.setOffreEmploi(offreEmploi);
        RHModel.create(application);
    
        System.out.println("Database generation complete.");

//        System.out.println("Start traveling test");
//        emploi.getCompetenceRequireds()
//                .stream()
//                .map(CompetenceRequired::getCompetence)
//                .map(Competence::getObj)
//                .forEach(System.out::println);
//
//        for (CompetenceAcquired ca: candidat.getCompetenceAcquireds()) {
//            System.out.println(ca);
//        }
    

        System.out.println("Done.");
    }
}
