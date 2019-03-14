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
	
	private JLabel lblEntIndex = new JLabel();
	private JLabel lblCanIndex = new JLabel();

	/** The frame. */
	private JFrame f;

	/** The panels. */
	private JPanel panelDataEntreprise;
	private JPanel panelDataCandidat;
	private JPanel panelCompetenceEntreprise;
	private JPanel panelCompetenceCandidat;

	/** The menu bar elements. */
	private JButton btnEntreprisePrev;
	private JButton btnEntrepriseNext;
	private JButton btnCandidatPrev;
	private JButton btnCandidatNext;
	
	/** Custom colors. */
	private Color backgroundColor = new Color(40, 40, 40);

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
	 * Init the CompetenceComparator window.
	 */
	public void init() {

		initFramesAndPanels();
		initButtons();
		
		//First refresh, add values in labels (without f.setVisible(true))
		refreshEntreprise();
		refreshCandidat();
		
		initEntreprisePanels();
		initCandidatPanels();
	}

	/**
	 * Init the JFrame and JPanels.
	 */
	public void initFramesAndPanels() {
		f = new JFrame("Gestion des offres d'emplois");
		f.setLayout(new MigLayout("", 
				"[175!][175!][175!][175!]", 
				"[30!][200!][200!]"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(backgroundColor);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelDataEntreprise = new JPanel(new MigLayout("", 
				"[125!][200!]", ""));
		panelDataCandidat = new JPanel(new MigLayout("", 
				"[125!][200!]", ""));
		panelCompetenceEntreprise = new JPanel(new MigLayout("", 
				"[125!][125!]", ""));
		panelCompetenceCandidat = new JPanel(new MigLayout("", 
				"[125!][125!]", ""));
		
		panelDataEntreprise.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panelDataCandidat.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		panelDataEntreprise.setBackground(backgroundColor);
		panelDataCandidat.setBackground(backgroundColor);
		panelCompetenceEntreprise.setBackground(backgroundColor);
		panelCompetenceCandidat.setBackground(backgroundColor);
		
		JScrollPane scrollPaneEntreprise = new JScrollPane(panelCompetenceEntreprise);
		JScrollPane scrollPaneCandidat = new JScrollPane(panelCompetenceCandidat);

		scrollPaneEntreprise.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCandidat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		f.add(panelDataEntreprise, "cell 0 1 1 1, top, center");
		f.add(panelDataCandidat, "cell 2 1 3 1, top, center");
		f.add(scrollPaneEntreprise, "cell 0 2 2 2, top, center");
		f.add(scrollPaneCandidat, "cell 2 2 4 2, top, center");
	}
	
	/**
	 * Init the entreprise panels.
	 */
	public void initEntreprisePanels() {
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
		
		lblEntIndex.setForeground(Color.WHITE);
	}
	
	/**
	 * Init the candidat panels.
	 */
	public void initCandidatPanels() {
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
		
		lblCanIndex.setForeground(Color.WHITE);
	}
	
	/**
	 * Init the buttons.
	 */
	public void initButtons() {
		btnEntreprisePrev = new JButton("Prev");
		btnEntreprisePrev.addActionListener(e -> handleBtnEntreprisePrevClicked());
		f.add(btnEntreprisePrev, "cell 0 0, bottom, center, split 2");
		
		btnEntrepriseNext = new JButton("Next");
		btnEntrepriseNext.addActionListener(e -> handleBtnEntrepriseNextClicked());
		f.add(btnEntrepriseNext, "bottom, center");
		
		f.add(lblEntIndex, "bottom, center");
		
		btnCandidatPrev = new JButton("Prev");
		btnCandidatPrev.addActionListener(e -> handleBtnCandidatPrevClicked());
		f.add(btnCandidatPrev, "bottom, center, split 2");
		
		btnCandidatNext = new JButton("Next");
		btnCandidatNext.addActionListener(e -> handleBtnCandidatNextClicked());
		f.add(btnCandidatNext, "bottom, center");
		
		f.add(lblCanIndex, "bottom, center");
	}
	
	/**
	 * Refresh the whole window and data.
	 */
	public void refresh() {
		refreshEntreprise();
		refreshCandidat();
		
		f.pack();
		f.setVisible(true);
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
		
		lblEntIndex.setText("Index: " + String.valueOf(selectedEntrepriseIndex));
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
		
		lblCanIndex.setText("Index: " + String.valueOf(selectedCandidatIndex));
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

	private void handleBtnEntreprisePrevClicked() {
    	selectedEntrepriseIndex--;
    	refresh();
	}
	
	private void handleBtnEntrepriseNextClicked() {
			selectedEntrepriseIndex++;
			refresh();
	}
	
	private void handleBtnCandidatPrevClicked() {
			selectedCandidatIndex--;
			refresh();
	}
	
	private void handleBtnCandidatNextClicked() {
			selectedCandidatIndex++;
			refresh();
	}
}
