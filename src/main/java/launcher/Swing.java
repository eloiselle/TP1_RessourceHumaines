package launcher;

import java.awt.Color;
import java.io.IOException;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Swing {

	public static void main(String[] arguments) throws IOException {

		//Data variables
		String[] columnNames = { "Emploi ", "Personne contact ", "Téléphone ", "Email", "Date fin", "Nombre postes" };

		Object[][] data = { { "Data1" }, { "Data2" }, { "Data3" }, { "Data4" }, { "Data5" }, { "Data6" } };

		//Swing elements
		JTable table = new JTable(data, columnNames);
		JLabel lblOffreEmploi = new JLabel("Offre d'emploi");
		JLabel lblCandidat = new JLabel("Candidat");
		JLabel lblTitreEmploi = new JLabel("titreEmploi");
		JLabel lblNomPrenom = new JLabel("Nom, Prénom");

		//Custom colors
		Color cBlack = new Color(40, 40, 40);
		Color cGray = new Color(80, 80, 80);
		Color cYellow = new Color(0, 40, 40);

		//Setup of frame
		JFrame f = new JFrame("Gestion des offres d'emplois");
		f.setLayout(new MigLayout("",
				"[40][150!][200!][150!][80!][150!][200!][150!][40]",
				"[grow][20!][25!][25!][20!][300!][100!][grow]"));
		f.getContentPane().setBackground(cBlack);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.getContentPane().add(lblOffreEmploi, "cell 2 2, center");
		f.getContentPane().add(lblCandidat, "cell 6 2, center");
		f.getContentPane().add(lblTitreEmploi, "cell 2 3, center");
		f.getContentPane().add(lblNomPrenom, "cell 6 3, center");
		f.getContentPane().add(table, "cell 1 3 3 3");

		//Setup of elements
		lblOffreEmploi.setForeground(Color.WHITE);
		lblCandidat.setForeground(Color.WHITE);
		lblTitreEmploi.setForeground(Color.WHITE);
		lblNomPrenom.setForeground(Color.WHITE);

		//Screen visible
		f.pack();
		f.setVisible(true);
	}

}