package launcher;

import java.awt.Color;
import java.io.IOException;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Swing {

	public static void main(String[] arguments) throws IOException {

		JLabel lblOffreEmploi = new JLabel("Offre d'emploi");
		JLabel lblCandidat = new JLabel("Candidat");
		JLabel lblTitreEmploi = new JLabel("titreEmploi");
		JLabel lblNomPrenom = new JLabel("Nom, Prénom");

		/*lblOffreEmploi.setBackground(Color.BLUE);
		lblOffreEmploi.setOpaque(true);*/
		
		/* JFrame.setDefaultLookAndFeelDecorated(true); */
		JFrame f = new JFrame("Gestion des offres d'emplois");
		f.setLayout(new MigLayout(
				"",
				"[40][150!][200!][150!][80!][150!][200!][150!][40]",
				"[grow][20!][25!][25!][20!][300!][100!][grow]"));
		
		f.setBackground(Color.BLACK);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.add(lblOffreEmploi, "cell 2 2, center");
		f.add(lblCandidat, "cell 6 2, center");
		f.add(lblTitreEmploi, "cell 2 3, center");
		f.add(lblNomPrenom, "cell 6 3, center");
		
		f.pack();
		f.setVisible(true);
	}

	/*private static void createAndShowGUI() {

		// button.setActionCommand("Submit");
		// button.addActionListener(new ButtonActionListener());

		// Added to the frame
		frame.getContentPane().add(lblImagerySet, "align right");
		frame.getContentPane().add(txtFldImagerySet, "wrap");

		frame.getContentPane().add(lblCenterPoint, "align right");
		frame.getContentPane().add(txtFldCenterPoint, "wrap");

		frame.getContentPane().add(lblOrientation, "align right");
		frame.getContentPane().add(txtFldOrientation, "wrap");

		frame.getContentPane().add(lblZoomLvl, "align right");
		frame.getContentPane().add(txtFldZoomLvl, "wrap");

		frame.getContentPane().add(lblBingMapsAPIKey, "align right");
		frame.getContentPane().add(txtFldBingMapsAPIKey, "wrap");

		frame.getContentPane().add(button, "span, grow");

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}*/

}