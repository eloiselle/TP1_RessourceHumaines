package launcher;

import facade.RHModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CertificationView {
    
    CertificationController ctrl;
    private static final String TITLE        = "Head Hunter - Certification";
    private static final int    MIN_WIDTH    = 400;
    private static final int    MIN_HEIGHT   = 100;
    private static final String DEFAULT_TEXT = "Choose one option in the menu";
    private              JFrame f;
    private              JLabel label;
    private              JLabel lNom;
    private              JLabel lDesc;
    private              int    count;
    
    
    JTextField tfNom;
    JTextArea  taDesc;
    
    JPanel leftPanel;
    JPanel rightPanel;
    JPanel statusPanel;
    
    
    JButton bUpdate;
    JButton bSaveToObject;
    JButton bSaveToDB;
    JButton bDelete;
    
    // ************************************************************************
    
    public CertificationView(CertificationController cc) { this.ctrl = cc; }
    
    
    /** Main */
    
    public void run()  throws ClassNotFoundException{
        
        RHModel.init();
        initFrame();
    }
    
    public void initFrame() {
        
        
        f = new JFrame(TITLE);
        initFrameElements();
        initFrameProperties();
        updateView();
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
        label = new JLabel("id : ");
        lNom = new JLabel("Nom : ");
        lDesc = new JLabel("Description : ");
        
        // Button
        
        bUpdate = new JButton("Update");
        bUpdate.addActionListener(e -> handleUpdateButtonClicked());
        
        bSaveToObject = new JButton("SaveToObject");
        bSaveToObject.addActionListener(e -> ctrl.saveToObject());
        
        bSaveToDB = new JButton("SaveToDB");
        bSaveToDB.addActionListener(e -> ctrl.saveToDB());
        
        bDelete = new JButton("Delete");
        bDelete.addActionListener(e -> ctrl.delete());
        
        // Field
        tfNom = new JTextField();
        tfNom.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent actionEvent) { handleFieldChanged(); }
        });
        
        taDesc = new JTextArea();
        taDesc.setRows(5);
        taDesc.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void removeUpdate(DocumentEvent e) { handleFieldChanged(); }
            @Override
            public void insertUpdate(DocumentEvent e) { handleFieldChanged(); }
            @Override
            public void changedUpdate(DocumentEvent arg0) { handleFieldChanged(); }
        });
        
        initLeftPanel();
        leftPanel.add(bUpdate);
        leftPanel.add(bSaveToObject);
        leftPanel.add(bSaveToDB);
        leftPanel.add(bDelete);
        
        initRightPanel();
        initStatusBar();
        
        // Layout
        f.add(leftPanel, BorderLayout.WEST);
        f.add(rightPanel, BorderLayout.CENTER);
        f.add(statusPanel, BorderLayout.SOUTH);
        
    }
    
    public void initStatusBar() {
        
        statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        
    }
    
    public void initLeftPanel() {
        
        leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    
    public void initRightPanel() {
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Vertical
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rightPanel.add(label);
        rightPanel.add(lNom);
        rightPanel.add(tfNom);
        rightPanel.add(lDesc);
        rightPanel.add(taDesc);
        
    }
    
    // ************************************************************************
    
    public void handleFieldChanged() {
        
        System.out.println("Field Changed");
        ctrl.saveToObject();
    }
    
    public void handleUpdateButtonClicked() {
        
        System.out.println("handleUpdateButtonClicked");
        System.out.println(ctrl.getCertification());
        updateView();
    }
    
    public void updateView() {
        
        System.out.println("Updated");
        
        if (ctrl.getCertification().getId() == 0) {
            label.setText("Id : Unsaved");
            bDelete.setEnabled(false);
        } else {
            label.setText("Id : " + ctrl.getCertification().getId());
            bDelete.setEnabled(true);
        }
    }
    
    // ************************************************************************
    
    public String getNom()  { return tfNom.getText();}
    public String getDesc() { return taDesc.getText();}
    
}
