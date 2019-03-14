/*
 * 
 */
package launcher;

import domain.*;
import java.awt.Color;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 * The Class to compare competences.
 */
public class CompetenceComparator {

	/** The selected index. */
	private int selectedEntrepriseIndex = 0;
	private int selectedCandidatIndex = 0;

	/** The frame. */
	private JFrame f;

	/** The panels. */
	private JPanel panelDataEntreprise;
	private JPanel panelDataCandidat;
	private JPanel panelCompetenceEntreprise;
	private JPanel panelCompetenceCandidat;
	private JMenuBar navBar;

	/** Custom colors. */
	private Color cBlack = new Color(40, 40, 40);

	/** Entreprise elements. */
	private JLabel lblEntrepriseHeader[] = { 
			new JLabel("Offre d'emploi"), 
			new JLabel("Entreprise"),
			new JLabel("Personne contact"), 
			new JLabel("Telephone"), 
			new JLabel("Courriel"), 
			new JLabel("Date fin"),
			new JLabel("Nombre postes") };

	private List<JLabel> lblEntrepriseData = new ArrayList<>();
	private List<JLabel> lblEntrepriseCompetence = new ArrayList<>();
	private List<JLabel> lblEntrepriseLevel = new ArrayList<>();

	/** Candidat elements. */
	private JLabel lblCandidatHeader[] = { 
			new JLabel("Candidat"), 
			new JLabel("Telephone"), 
			new JLabel("Courriel"),
			new JLabel("Date naissance"), 
			new JLabel("NAS") };

	private List<JLabel> lblCandidatData = new ArrayList<>();
	private List<JLabel> lblCandidatCompetence = new ArrayList<>();
	private List<JLabel> lblCandidatLevel = new ArrayList<>();

	/** Data variables. */
	private TypeEmploi teManuel;
	private TypeEmploi teInformatique;
	private TypeEmploi teService;
	
	private EtatOffreEmploi eoeRecherche;
	private EtatOffreEmploi eoeHired;
	private EtatOffreEmploi eoeNotFound;
	private EtatOffreEmploi eoeWaiting;
	private EtatOffreEmploi eoeProcessing;
	
	private Certification certification;
	
	private Competence cmpJava;
	private Competence cmpJS;
	private Competence cmpCpp;
	
	private Candidat candidat;
	private Emploi emploi;
	private Entreprise entreprise;
	private Recruteur recruteur;
	private OffreEmploi offreEmploi;
	private Application application;
	
	/**
	 * The main method.
	 *
	 * @param arguments the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] arguments) throws IOException {
		CompetenceComparator fenetre = new CompetenceComparator();
		fenetre.generateData();
		fenetre.init();
		fenetre.refresh();
	}

	/**
	 * Init the main frame and panel configurations.
	 */
	public void init() {

		f = new JFrame("Gestion des offres d'emplois");
		f.setLayout(new MigLayout("", 
				"[350!][350!]", 
				"[100!][200!][200!]"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(cBlack);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelDataEntreprise = new JPanel(new MigLayout("", 
				"[125!][200!]", ""));
		panelDataCandidat = new JPanel(new MigLayout("", 
				"[125!][200!]", ""));
		panelCompetenceEntreprise = new JPanel(new MigLayout("", 
				"[125!][125!]", ""));
		panelCompetenceCandidat = new JPanel(new MigLayout("", 
				"[125!][125!]", ""));

		navBar = new JMenuBar();
		navBar.setBackground(Color.WHITE);
		
		panelDataEntreprise.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panelDataCandidat.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		panelDataEntreprise.setBackground(cBlack);
		panelDataCandidat.setBackground(cBlack);
		panelCompetenceEntreprise.setBackground(cBlack);
		panelCompetenceCandidat.setBackground(cBlack);
		
	}

	/**
	 * Refresh the whole window and data.
	 */
	public void refresh() {

		// Variables temporaires
		refreshEntreprise();
		refreshCandidat();
		
		refreshFrame();
	}
	
	/**
	 * Refresh the entreprise panels.
	 */
	public void refreshEntreprise() {
		
		lblEntrepriseData.clear();
		lblEntrepriseCompetence.clear();
		
		// Refresh entreprise labels
		lblEntrepriseData.add(new JLabel(offreEmploi.getEmploi().getTitre()));
		lblEntrepriseData.add(new JLabel(offreEmploi.getRecruteurInterne().getEntreprise().getName()));
		lblEntrepriseData.add(new JLabel(offreEmploi.getRecruteurInterne().getNom() + ", "
				+ offreEmploi.getRecruteurInterne().getPrenom()));
		lblEntrepriseData.add(new JLabel(String.valueOf(offreEmploi.getRecruteurInterne().getTelephone())
				.replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d+)", "$1+($2) $3-$4")));
		lblEntrepriseData.add(new JLabel(offreEmploi.getRecruteurInterne().getEmail()));
		lblEntrepriseData.add(new JLabel(offreEmploi.getDateFin()));
		lblEntrepriseData.add(new JLabel(String.valueOf(offreEmploi.getNbrPostes())));
		
		// Refresh entreprise competences + niveaux
		for (CompetenceRequired c : offreEmploi.getEmploi().getCompetenceRequireds()) {
			lblEntrepriseCompetence.add(new JLabel(c.getCompetence().getName()));
			lblEntrepriseLevel.add(new JLabel(String.valueOf(c.getLevel())));
		}
		;

		// Affichage headers
		for (int i = 0; i < lblEntrepriseHeader.length; i++) {
			lblEntrepriseHeader[i].setForeground(Color.WHITE);
			panelDataEntreprise.add(lblEntrepriseHeader[i], "cell 0 " + i);
		}
		
		// Affichage labels
		for (int i = 0; i < lblEntrepriseData.size(); i++) {
			lblEntrepriseData.get(i).setForeground(Color.WHITE);
			panelDataEntreprise.add(lblEntrepriseData.get(i), "cell 1 " + i);
		}

		// Affichage competence
		for (int i = 0; i < lblEntrepriseCompetence.size(); i++) {
			lblEntrepriseCompetence.get(i).setForeground(Color.WHITE);
			panelCompetenceEntreprise.add(lblEntrepriseCompetence.get(i), "cell 0 " + i);
		}

		// Affichage niveau
		for (int i = 0; i < lblEntrepriseLevel.size(); i++) {
			lblEntrepriseLevel.get(i).setForeground(Color.WHITE);
			panelCompetenceEntreprise.add(lblEntrepriseLevel.get(i), "cell 1 " + i + ", right");
		}
	}
	
	/**
	 * Refresh the candidat panels.
	 */
	public void refreshCandidat() {
		
		lblCandidatData.clear();
		lblCandidatCompetence.clear();
		
		// Refresh candidat labels
		lblCandidatData.add(new JLabel(candidat.getNom() + ", " + candidat.getPrenom()));
		lblCandidatData.add(new JLabel(String.valueOf(candidat.getTelephone())
				.replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d+)", "$1+($2) $3-$4")));
		lblCandidatData.add(new JLabel(candidat.getEmail()));
		lblCandidatData.add(new JLabel(candidat.getDateNaissance()));
		lblCandidatData.add(new JLabel(candidat.getNAS().toString()));
		
		// Refresh candidat competences + niveaux
		for (CompetenceAcquired c : candidat.getCompetenceAcquireds()) {
			lblCandidatCompetence.add(new JLabel(c.getCompetence().getName()));
			lblCandidatLevel.add(new JLabel(String.valueOf(c.getLevel())));
		}
		;

		// Affichage headers
		for (int i = 0; i < lblCandidatHeader.length; i++) {
			lblCandidatHeader[i].setForeground(Color.WHITE);
			panelDataCandidat.add(lblCandidatHeader[i], "cell 0 " + i);
		}
		
		// Affichage labels
		for (int i = 0; i < lblCandidatData.size(); i++) {
			lblCandidatData.get(i).setForeground(Color.WHITE);
			panelDataCandidat.add(lblCandidatData.get(i), "cell 1 " + i);
		}

		// Affichage competence
		for (int i = 0; i < lblCandidatCompetence.size(); i++) {
			lblCandidatCompetence.get(i).setForeground(Color.WHITE);
			panelCompetenceCandidat.add(lblCandidatCompetence.get(i), "cell 0 " + i);
		}

		// Affichage niveau
		for (int i = 0; i < lblCandidatLevel.size(); i++) {
			lblCandidatLevel.get(i).setForeground(Color.WHITE);
			panelCompetenceCandidat.add(lblCandidatLevel.get(i), "cell 1 " + i + ", right");
		}
	}
	
	/**
	 * Refresh the main frame.
	 */
	public void refreshFrame() {
		
		JScrollPane sp1 = new JScrollPane(panelCompetenceEntreprise);
		JScrollPane sp2 = new JScrollPane(panelCompetenceCandidat);

		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		f.add(navBar, "cell 0 0 1 0, top, center");
		f.add(panelDataEntreprise, "cell 0 1, top, center");
		f.add(panelDataCandidat, "cell 1 1, top, center");
		f.add(sp1, "cell 0 2, top, center");
		f.add(sp2, "cell 1 2, top, center");
		
		f.pack();
		f.setVisible(true);
	}
	
	/**
	 * Generate data.
	 */
	public void generateData() {
		
		// TYPE

		teManuel = new TypeEmploi();
		teManuel.setName("Manuel");
		teManuel.setDescription("Emploi manuel");

		teInformatique = new TypeEmploi();
		teInformatique.setName("Informatique");
		teInformatique.setDescription("Emploi relie au domaine de l'informatique");

		teService = new TypeEmploi();
		teService.setName("Service");
		teService.setDescription("Emploi relie au domaine du service a la clientele");

		// ETAT

		eoeRecherche = new EtatOffreEmploi();
		eoeRecherche.setName("Recherche");
		eoeRecherche.setDescription("L'entreprise recherche activement des candidat");

		eoeHired = new EtatOffreEmploi();
		eoeHired.setName("Hired");
		eoeHired.setDescription("Le poste a ete comble");

		eoeNotFound = new EtatOffreEmploi();
		eoeNotFound.setName("Not_Satisfied");
		eoeNotFound.setDescription("L'entreprise n'a pas trouver ce quelle cherche");

		eoeWaiting = new EtatOffreEmploi();
		eoeWaiting.setName("Waiting");
		eoeWaiting.setDescription("L'entreprise est en attente d'avancement");

		eoeProcessing = new EtatOffreEmploi();
		eoeProcessing.setName("Processing");
		eoeProcessing.setDescription("L'entreprise est en train d'evaluer les candidats");

		// Certification

		certification = new Certification();
		certification.setName("DEC en Informatique de gestion");
		certification.setDescription("Programmation, Base de donnees, Interface graphique, ...");

		// Competences

		cmpJava = new Competence();
		cmpJava.setName("Java");
		cmpJava.setDescription("Programmation OOP avec Java");
		cmpJava.setCertification(null);

		cmpJS = new Competence();
		cmpJS.setName("Javascript");
		cmpJS.setDescription("Programmation avec Javascript");
		cmpJS.setCertification(certification);

		cmpCpp = new Competence();
		cmpCpp.setName("C++");
		cmpCpp.setDescription("Programmation en C++ avec pointeurs");
		cmpCpp.setCertification(certification);

		// TEST DATA

		candidat = new Candidat();
		candidat.setPrenom("Anthony");
		candidat.setNom("Cote");
		candidat.setDateNaissance("1986-11-24");
		candidat.setEmail("coteanthony0@fakemail.com");
		candidat.setNAS(BigInteger.valueOf(123456789));
		candidat.setTelephone(BigInteger.valueOf(1892448451));

		candidat.earnCompetence(cmpJava, 3);
		candidat.earnCompetence(cmpCpp, 5);

		emploi = new Emploi();
		emploi.setTitre("Programmeur");
		emploi.setDescription("Tapper au hasard sur un clavier jusqu'a ce que ca compile");
		emploi.setTypeEmploi(teInformatique);

		emploi.requiereCompetence(cmpJS, 1);

		entreprise = new Entreprise();
		entreprise.setName("CGI");
		entreprise.setDescription("Entreprise de sherbrooke");

		recruteur = new Recruteur();
		recruteur.setPrenom("Alice");
		recruteur.setNom("Merveille");
		recruteur.setTelephone(BigInteger.valueOf(1895554321));
		recruteur.setEmail("alice@rh.com");
		recruteur.setNas(BigInteger.valueOf(123456789));
		recruteur.setCommission(12);
		recruteur.setEntreprise(entreprise);

		offreEmploi = new OffreEmploi();
		offreEmploi.setDateParution("2019-02-02");
		offreEmploi.setDateFin("2019-03-03");
		offreEmploi.setSalaireOffert(20);
		offreEmploi.setNbrPostes(2);
		offreEmploi.setEmploi(emploi);
		offreEmploi.setEtatOffreEmploi(eoeProcessing);
		offreEmploi.setRecruteurInterne(recruteur);
		offreEmploi.setRecruteurExterne(recruteur);

		application = new Application();
		application.setCvPath("/home/rh/cv/coteanthony20180303.doc");
		application.setDateApplication("2019-02-02");
		application.setDateEntrevue("2019-03-03");
		application.setHeureEntrevue("13:15");
		application.setAdresseEntrevue("400 rue Marquette");
		application.setCommentaire("...");
		application.setOffreEmploi(offreEmploi);
	}
}
