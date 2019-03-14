package launcher;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Swing {

	private int selectedIndex = 0;

	// Frame
	private JFrame f;
	private JPanel panelDataEntreprise;
	private JPanel panelDataCandidat;
	private JPanel panelCompetenceEntreprise;
	private JPanel panelCompetenceCandidat;

	// Custom colors
	private Color cBlack = new Color(40, 40, 40);
	private Color cGray = new Color(80, 80, 80);
	private Color cYellow = new Color(0, 40, 40);

	// Entreprise
	private JLabel lblEntrepriseHeader[] = { new JLabel("Offre d'emploi"), new JLabel("Entreprise"),
			new JLabel("Telephone"), new JLabel("Courriel"), new JLabel("Date fin"), new JLabel("Nombre postes") };

	private List<JLabel> lblEntrepriseData = new ArrayList<>();
	private List<JLabel> lblEntrepriseCompetence = new ArrayList<>();
	private List<JLabel> lblEntrepriseLevel = new ArrayList<>();

	// Candidat
	private JLabel lblCandidatHeader[] = { new JLabel("Candidat"), new JLabel("Telephone"), new JLabel("Courriel"),
			new JLabel("Date fin"), new JLabel("Nombre postes") };

	private List<JLabel> lblCandidatData = new ArrayList<>();
	private List<JLabel> lblCandidatCompetence = new ArrayList<>();
	private List<JLabel> lblCandidatLevel = new ArrayList<>();

	// Main
	public static void main(String[] arguments) throws IOException {

		Swing fenetre = new Swing();
		fenetre.init();
		fenetre.refresh();

	}

	public void init() {

		// Setup of JFrame
		f = new JFrame("Gestion des offres d'emplois");
		f.setLayout(new MigLayout("",
				"[250!][250!]", 
				"[250!][250!]"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(cBlack);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setup of data panels
		panelDataEntreprise = new JPanel(new MigLayout("", 
				"[100!][100!]", 
				""));
		panelDataCandidat = new JPanel(new MigLayout("", 
				"[100!][100!]", 
				""));
		panelCompetenceEntreprise = new JPanel(new MigLayout("", 
				"[125!][125!]", 
				""));
		panelCompetenceCandidat = new JPanel(new MigLayout("", 
				"[125!][125!]", 
				""));

		panelDataEntreprise.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panelDataCandidat.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		/*
		 * panelCompetenceEntreprise.setBorder(BorderFactory.createLineBorder(Color.
		 * WHITE));
		 * panelCompetenceCandidat.setBorder(BorderFactory.createLineBorder(Color.WHITE)
		 * );
		 */

		panelDataEntreprise.setBackground(cBlack);
		panelDataCandidat.setBackground(cBlack);
		panelCompetenceEntreprise.setBackground(cBlack);
		panelCompetenceCandidat.setBackground(cBlack);

		// Setup of headers
		for (int i = 0; i < lblEntrepriseHeader.length; i++) {
			lblEntrepriseHeader[i].setForeground(Color.WHITE);
			panelDataEntreprise.add(lblEntrepriseHeader[i], "cell 0 " + i);
		}

		for (int i = 0; i < lblCandidatHeader.length; i++) {
			lblCandidatHeader[i].setForeground(Color.WHITE);
			panelDataCandidat.add(lblCandidatHeader[i], "cell 0 " + i);
		}
	}

	public void refresh() {

		// selectedIndex int variable (pour la BD)

		lblEntrepriseData.clear();
		lblCandidatData.clear();

		// Variables temporaires

		// Candidat

		String CandidatNomPrenom = "nomPrenom";
		String CandidatNoTelephone = "noTelephone";
		String CandidatEmail = "email";
		String CandidatDateFin = "dateFin";
		String CandidatNbrPoste = "nbrPoste";
		int nbCandidatCompetence = 100;

		// Entreprise
		String EntrepriseTitreEmploi = "titreEmploi";
		String EntrepriseNomEntreprise = "nomEntreprise";
		String EntrepriseNoTelephone = "noTelephone";
		String EntrepriseEmail = "email";
		String EntrepriseDateFin = "dateFin";
		String EntrepriseNbrPoste = "nbrPoste";
		int nbEntrepriseCompetence = 25;

		// MAJ des labels

		// Candidat
		lblCandidatData.add(new JLabel(": " + CandidatNomPrenom));
		lblCandidatData.add(new JLabel(": " + CandidatNoTelephone));
		lblCandidatData.add(new JLabel(": " + CandidatEmail));
		lblCandidatData.add(new JLabel(": " + CandidatDateFin));
		lblCandidatData.add(new JLabel(": " + CandidatNbrPoste));
		for (int i = 0; i < nbCandidatCompetence; i++) {
			lblCandidatCompetence.add(new JLabel("competence"));
			lblCandidatLevel.add(new JLabel("level"));
		}
		;

		// Entreprise
		lblEntrepriseData.add(new JLabel(": " + EntrepriseTitreEmploi));
		lblEntrepriseData.add(new JLabel(": " + EntrepriseNomEntreprise));
		lblEntrepriseData.add(new JLabel(": " + EntrepriseNoTelephone));
		lblEntrepriseData.add(new JLabel(": " + EntrepriseEmail));
		lblEntrepriseData.add(new JLabel(": " + EntrepriseDateFin));
		lblEntrepriseData.add(new JLabel(": " + EntrepriseNbrPoste));
		for (int i = 0; i < nbEntrepriseCompetence; i++) {
			lblEntrepriseCompetence.add(new JLabel("competence"));
			lblEntrepriseLevel.add(new JLabel("level"));
		}
		;

		// Refresh affichage

		// Candidat
		for (int i = 0; i < lblCandidatData.size(); i++) {
			lblCandidatData.get(i).setForeground(Color.WHITE);
			panelDataCandidat.add(lblCandidatData.get(i), "cell 1 " + i);
		}

		// Entreprise
		for (int i = 0; i < lblEntrepriseData.size(); i++) {
			lblEntrepriseData.get(i).setForeground(Color.WHITE);
			panelDataEntreprise.add(lblEntrepriseData.get(i), "cell 1 " + i);
		}

		// Level
		for (int i = 0; i < lblEntrepriseLevel.size(); i++) {
			lblEntrepriseLevel.get(i).setForeground(Color.WHITE);
			panelCompetenceEntreprise.add(lblEntrepriseLevel.get(i), "cell 1 " + i);
		}

		// Level
		for (int i = 0; i < lblCandidatLevel.size(); i++) {
			lblCandidatLevel.get(i).setForeground(Color.WHITE);
			panelCompetenceCandidat.add(lblCandidatLevel.get(i), "cell 1 " + i);
		}

		// Competence
		for (int i = 0; i < lblEntrepriseCompetence.size(); i++) {
			lblEntrepriseCompetence.get(i).setForeground(Color.WHITE);
			panelCompetenceEntreprise.add(lblEntrepriseCompetence.get(i), "cell 0 " + i);
		}

		// Competence
		for (int i = 0; i < lblCandidatCompetence.size(); i++) {
			lblCandidatCompetence.get(i).setForeground(Color.WHITE);
			panelCompetenceCandidat.add(lblCandidatCompetence.get(i), "cell 0 " + i);
		}

		JScrollPane sp1 = new JScrollPane(panelCompetenceEntreprise);
		JScrollPane sp2 = new JScrollPane(panelCompetenceCandidat);

		sp1.setSize(500, 500);
		sp2.setSize(500, 500);

		f.add(panelDataEntreprise, "cell 0 0, center");
		f.add(panelDataCandidat, "cell 1 0, center");
		f.add(sp1, "cell 0 1");
		f.add(sp2, "cell 1 1");
		f.pack();
		f.setVisible(true);
	}
}
