package facade;

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
        
        // TEST DATA
    
        Candidat candidat = new Candidat();
        candidat.setPrenom("Anthony");
        candidat.setNom("Cote");
        candidat.setDateNaissance("1986-11-24");
        candidat.setEmail("coteanthony0@gmail.com");
        candidat.setNAS(BigInteger.valueOf(123456789));
        candidat.setTelephone(BigInteger.valueOf(1892448451));
        RHModel.ajouteCandidat(candidat);
    
        Certification certification = new Certification();
        certification.setName("DEC en Informatique de gestion");
        certification.setDescription("Programmation, Base de donnees, Interface graphique, ...");
        RHModel.create(certification);
    

        Competence competence = new Competence();
        competence.setName("Java");
        competence.setDescription("Programmation OOP avec Java");
        competence.setCertification(certification);
        RHModel.create(competence);
    
        Emploi emploi = new Emploi();
        emploi.setTitre("Programmeur");
        emploi.setDescription("Tapper au hasard sur un clavier jusqu'a ce que ca compile");
        emploi.setTypeEmploi(teService);
        RHModel.create(emploi);
    
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
    


    }
        
        
    
    
    
    
}
