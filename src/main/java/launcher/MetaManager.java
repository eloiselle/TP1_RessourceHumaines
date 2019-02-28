package launcher;

import javax.swing.*;
import java.awt.*;


public class MetaManager {
    
    private static final String TITLE        = "Head Hunter - Competence Matching";
    private static final int    MIN_WIDTH    = 400;
    private static final int    MIN_HEIGHT   = 100;
    private static final String DEFAULT_TEXT = "Choose one option in the menu";
    private              JFrame f;
    private              JLabel label;
    private              int    count;
    
    /** Main */
    public static void main(String[] arguments) { new MetaManager().run();}
    
    public void run()                           { initFrame();}
    
    public void initFrame() {
        
        f = new JFrame(TITLE);
        initFrameElements();
        initFrameProperties();
    }
    
    public void initFrameProperties() {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        f.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        f.pack();
        f.setLocationRelativeTo(null);  // Center window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    public void initFrameElements() {
        
        // Label
        label = new JLabel(DEFAULT_TEXT);
        
        // Button
        JButton bCandidat = new JButton("Candidat");
        bCandidat.addActionListener(e -> handleButtonClicked());
        
        JButton bEmploi = new JButton("Emploi");
        bEmploi.addActionListener(e -> handleButtonClicked());
        
        JButton bCompetence = new JButton("Competence");
        bCompetence.addActionListener(e -> handleButtonClicked());
        
        JButton bApplication = new JButton("Application");
        bApplication.addActionListener(e -> handleButtonClicked());
        
        
        // Panel
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.add(bCandidat);
        leftPanel.add(bEmploi);
        leftPanel.add(bCompetence);
        leftPanel.add(bApplication);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JPanel rightPanel = new JPanel();
        rightPanel.add(label);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Layout
        f.getContentPane().add(leftPanel, BorderLayout.WEST);
        f.getContentPane().add(rightPanel, BorderLayout.CENTER);
        
    }
    
    public void handleButtonClicked() {
        
        count++;
        label.setText("Clicked " + count + " times");
        System.out.println("Have fun!");
    }
    
}
