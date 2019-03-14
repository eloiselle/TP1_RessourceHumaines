/*
 *
 */
package launcher;

import domain.*;

import java.awt.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import model.DBCreator;
import model.RHModel;
import net.miginfocom.swing.MigLayout;

/**
 The Class to compare competences. */
public class CompetenceComparator {
    
    /** The selected index. */
    private int selectedOffreEmploiIndex = 1;
    private int selectedCandidatIndex    = 1;
    
    private JLabel lblOffreEmploiIndex = new JLabel();
    private JLabel lblCandidatIndex    = new JLabel();
    
    /** The frame. */
    private JFrame f;
    
    /** The panels. */
    private JPanel panelDataOffreEmploi;
    private JPanel panelDataCandidat;
    private JPanel panelCompetenceOffreEmploi;
    private JPanel panelCompetenceCandidat;
    
    /** The menu bar elements. */
    private JButton btnOffreEmploiPrev;
    private JButton btnOffreEmploiNext;
    private JButton btnCandidatPrev;
    private JButton btnCandidatNext;
    
    /** Custom colors. */
    private Color backgroundColor = new Color(40, 40, 40);
    
    /** Entreprise elements. */
    private JLabel lblOffreEmploiHeader[] = { new JLabel("Offre d'emploi"), new JLabel("Entreprise"), new JLabel("Personne contact"), new JLabel("Telephone"), new JLabel("Courriel"), new JLabel("Date fin"), new JLabel("Nombre postes") };
    
    private List <JLabel> lblOffreEmploiData       = new ArrayList <>();
    private List <JLabel> lblOffreEmploiCompetence = new ArrayList <>();
    private List <JLabel> lblOffreEmploiLevel      = new ArrayList <>();
    
    /** Candidat elements. */
    private JLabel lblCandidatHeader[] = { new JLabel("Candidat"), new JLabel("Telephone"), new JLabel("Courriel"), new JLabel("Date naissance"), new JLabel("NAS") };
    
    private List <JLabel> lblCandidatData       = new ArrayList <>();
    private List <JLabel> lblCandidatCompetence = new ArrayList <>();
    private List <JLabel> lblCandidatLevel      = new ArrayList <>();
    
    /** Data variables. */
    
    private Candidat    candidat;
    private Emploi      emploi;
    private Entreprise  entreprise;
    private Recruteur   recruteur;
    private OffreEmploi offreEmploi;
    
    /**
     The main method.
     @param arguments the arguments
     @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] arguments) throws IOException, ClassNotFoundException {
        
        // Load database
        RHModel.init();
        DBCreator.generateData();
        
        new CompetenceComparator().run();
    }
    
    public void run() {
        
        loadDefaultData();
        
        init();
        refreshFrame();
    }
    
    /**
     Init the CompetenceComparator window.
     */
    public void init() {
        
        initFramesAndPanels();
        initButtons();
        
        //First refreshFrame, add values in labels (without f.setVisible(true))
        refreshOffreEmploi();
        refreshCandidat();
        
        

        initOffreEmploiPanels();
        initCandidatPanels();
    }
    
    /**
     Init the JFrame and JPanels.
     */
    public void initFramesAndPanels() {
        
        f = new JFrame("Gestion des offres d'emplois");
        f.setLayout(new MigLayout("", "[175!][175!][175!][175!]", "[30!][200!][200!]"));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(backgroundColor);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelDataOffreEmploi = new JPanel(new MigLayout("", "[125!][200!]", ""));
        panelDataCandidat = new JPanel(new MigLayout("", "[125!][200!]", ""));
        panelCompetenceOffreEmploi = new JPanel(new MigLayout("", "[125!][125!]", ""));
        panelCompetenceCandidat = new JPanel(new MigLayout("", "[125!][125!]", ""));
        
        panelDataOffreEmploi.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelDataCandidat.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        panelDataOffreEmploi.setBackground(backgroundColor);
        panelDataCandidat.setBackground(backgroundColor);
        panelCompetenceOffreEmploi.setBackground(backgroundColor);
        panelCompetenceCandidat.setBackground(backgroundColor);
        
        JScrollPane scrollPaneOffreEmploi = new JScrollPane(panelCompetenceOffreEmploi);
        JScrollPane scrollPaneCandidat   = new JScrollPane(panelCompetenceCandidat);
        
        scrollPaneOffreEmploi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneCandidat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        f.add(panelDataOffreEmploi, "cell 0 1 1 1, top, center");
        f.add(panelDataCandidat, "cell 2 1 3 1, top, center");
        f.add(scrollPaneOffreEmploi, "cell 0 2 2 2, top, center");
        f.add(scrollPaneCandidat, "cell 2 2 4 2, top, center");
    }
    
    /**
     Init the entreprise panels.
     */
    public void initOffreEmploiPanels() {
        
        // Affichage headers
        for (int i = 0; i < lblOffreEmploiHeader.length; i++) {
            lblOffreEmploiHeader[i].setForeground(Color.WHITE);
            panelDataOffreEmploi.add(lblOffreEmploiHeader[i], "cell 0 " + i);
        }
        
        // Affichage labels
        for (int i = 0; i < lblOffreEmploiData.size(); i++) {
            lblOffreEmploiData.get(i).setForeground(Color.WHITE);
            panelDataOffreEmploi.add(lblOffreEmploiData.get(i), "cell 1 " + i);
        }
        
        // Affichage competence
        for (int i = 0; i < lblOffreEmploiCompetence.size(); i++) {
            lblOffreEmploiCompetence.get(i).setForeground(Color.WHITE);
            panelCompetenceOffreEmploi.add(lblOffreEmploiCompetence.get(i), "cell 0 " + i);
        }
        
        // Affichage niveau
        for (int i = 0; i < lblOffreEmploiLevel.size(); i++) {
            lblOffreEmploiLevel.get(i).setForeground(Color.WHITE);
            panelCompetenceOffreEmploi.add(lblOffreEmploiLevel.get(i), "cell 1 " + i + ", right");
        }
        
        lblOffreEmploiIndex.setForeground(Color.WHITE);
    }
    
    /**
     Init the candidat panels.
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
        
        lblCandidatIndex.setForeground(Color.WHITE);
    }
    
    
    /**
     Init the buttons.
     */
    public void initButtons() {
        
        btnOffreEmploiPrev = new JButton("Prev");
        btnOffreEmploiPrev.addActionListener(e -> handleBtnOffreEmploiPrevClicked());
        f.add(btnOffreEmploiPrev, "cell 0 0, bottom, center, split 2");
        
        btnOffreEmploiNext = new JButton("Next");
        btnOffreEmploiNext.addActionListener(e -> handleBtnOffreEmploiNextClicked());
        f.add(btnOffreEmploiNext, "bottom, center");
        
        f.add(lblOffreEmploiIndex, "bottom, center");
        
        btnCandidatPrev = new JButton("Prev");
        btnCandidatPrev.addActionListener(e -> handleBtnCandidatPrevClicked());
        f.add(btnCandidatPrev, "bottom, center, split 2");
        
        btnCandidatNext = new JButton("Next");
        btnCandidatNext.addActionListener(e -> handleBtnCandidatNextClicked());
        f.add(btnCandidatNext, "bottom, center");
        
        f.add(lblCandidatIndex, "bottom, center");
    }
    
    // REFRESH ****************************************************************
    
    /**
     Refresh the whole window and data.
     */
    public void refreshFrame() {
        
        loadDefaultData();
        refreshOffreEmploi();
        refreshCandidat();
        
        f.pack();
        f.setVisible(true);
    }
    
    private void loadDefaultData() {
        
        candidat = RHModel.loadCandidat(1);
        emploi = RHModel.loadEmploi(1);
        entreprise = RHModel.loadEntreprise(1);
        recruteur = RHModel.loadRecruteur(1);
        offreEmploi = RHModel.loadOffreEmploi(1);
        
        offreEmploi.setEmploi(emploi);
        offreEmploi.setRecruteurInterne(recruteur);
        recruteur.setEntreprise(entreprise);
    }
    
    /**
     Refresh the entreprise panels.
     */
    public void refreshOffreEmploi() {
        
        lblOffreEmploiData.clear();
        lblOffreEmploiCompetence.clear();
        lblOffreEmploiLevel.clear();
        
    	// Refresh entreprise labels
           	// Init entreprise labels list
        lblOffreEmploiData.add(new JLabel(offreEmploi.getEmploi().getTitre()));
        lblOffreEmploiData.add(new JLabel(offreEmploi.getRecruteurInterne().getEntreprise().getName()));
        lblOffreEmploiData.add(new JLabel(offreEmploi.getRecruteurInterne().getNom() + ", " + offreEmploi.getRecruteurInterne().getPrenom()));
        lblOffreEmploiData.add(new JLabel(String.valueOf(offreEmploi.getRecruteurInterne().getTelephone()).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d+)", "$1+($2) $3-$4")));
        lblOffreEmploiData.add(new JLabel(offreEmploi.getRecruteurInterne().getEmail()));
        lblOffreEmploiData.add(new JLabel(offreEmploi.getDateFin()));
        lblOffreEmploiData.add(new JLabel(String.valueOf(offreEmploi.getNbrPostes())));
        
        // Init entreprise competences + niveaux
        for (CompetenceRequired c : offreEmploi.getEmploi().getCompetenceRequireds()) {
            lblOffreEmploiCompetence.add(new JLabel(c.getCompetence().getName()));
            lblOffreEmploiLevel.add(new JLabel(String.valueOf(c.getLevel())));
        }
        
        // Refresh entreprise competences + niveaux
        
        
        lblOffreEmploiIndex.setText("Index: " + String.valueOf(selectedOffreEmploiIndex));
        System.out.println(offreEmploi);
        
        f.pack();
    }
    
    /**
     Refresh the candidat panels.
     */
    public void refreshCandidat() {
        
        lblCandidatData.clear();
        lblCandidatCompetence.clear();
        lblCandidatLevel.clear();
        
        // Refresh candidat labels
        lblCandidatData.add(new JLabel(candidat.getNom() + ", " + candidat.getPrenom()));
        lblCandidatData.add(new JLabel(String.valueOf(candidat.getTelephone()).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d+)", "$1+($2) $3-$4")));
        lblCandidatData.add(new JLabel(candidat.getEmail()));
        lblCandidatData.add(new JLabel(candidat.getDateNaissance()));
        lblCandidatData.add(new JLabel(candidat.getNAS().toString()));
        
        // Refresh candidat competences + niveaux
        for (CompetenceAcquired c : candidat.getCompetenceAcquireds()) {
            lblCandidatCompetence.add(new JLabel(c.getCompetence().getName()));
            lblCandidatLevel.add(new JLabel(String.valueOf(c.getLevel())));
        }
        
        lblCandidatIndex.setText("Index: " + String.valueOf(selectedCandidatIndex));
        System.out.println(candidat);
    }
    
    // HANDLE BUTTON **********************************************************
    
    private void handleBtnOffreEmploiPrevClicked() {
        
        do {
            offreEmploi= RHModel.loadOffreEmploi(--selectedOffreEmploiIndex);
        } while (offreEmploi== null);
        
         refreshView();
    }
    
    private void handleBtnOffreEmploiNextClicked() {
        
        do {
            offreEmploi= RHModel.loadOffreEmploi(++selectedOffreEmploiIndex);
        } while (offreEmploi == null);
        
        refreshView();
    }
    
    private void handleBtnCandidatPrevClicked() {
        
        do {
            candidat = RHModel.loadCandidat(--selectedCandidatIndex);
        } while (candidat == null);
        
        refreshView();
    }
    
    private void handleBtnCandidatNextClicked() {
        
        do {
            candidat = RHModel.loadCandidat(++selectedCandidatIndex);
        } while (candidat == null);
        
        refreshView();
        
    }
    
    private void refreshView(){
        f.removeAll();
        f.setVisible(false);
        initFramesAndPanels();
        initButtons();
        refreshCandidat();
        refreshOffreEmploi();
        initCandidatPanels();
        initOffreEmploiPanels();
        refreshFrame();
    }
}
