package launcher;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CertificationView {
    
    private              CertificationController ctrl;
    private static final String                  TITLE      = "Head Hunter - Certification";
    private static final int                     MIN_WIDTH  = 400;
    private static final int                     MIN_HEIGHT = 100;
    private static final int                     NOT_IN_DB  = 0;
    private              JFrame                  f;
    private              JLabel                  lID;
    private              JLabel                  lNom;
    private              JLabel                  lDesc;
    
    private JTextField tfNom;
    private JTextArea  taDesc;
    
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel statusPanel;
    private JLabel statusLabel;
    
    private JButton bRefresh;
    private JButton bSave;
    private JButton bDelete;
    private JButton bNew;
    private JButton bLoad;
    
    // ************************************************************************
    
    public CertificationView(CertificationController cc) { this.ctrl = cc; }
    
    
    /** Main */
    
    public void run() throws ClassNotFoundException {
        
        initFrame();
        changeStatusBar("Init");
    }
    
    public void initFrame() {
        
        f = new JFrame(TITLE);
        initFrameElements();
        initFrameProperties();
        refresh();
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
        
        initLabels();
        initButtons();
        initFields();
        
        initLeftPanel();
        initRightPanel();
        initStatusBar();
        
        initLayout();
    }
    
    
    public void initLabels() {
        
        lID = new JLabel("ID : ");
        lNom = new JLabel("Nom : ");
        lDesc = new JLabel("Description : ");
        
    }
    
    public void initFields() {
        
        tfNom = new JTextField();
        tfNom.getDocument().addDocumentListener(defaultFieldListener());
        
        taDesc = new JTextArea();
        taDesc.setRows(5);
        taDesc.getDocument().addDocumentListener(defaultFieldListener());
    }
    
    public void initButtons() {
        
        bLoad = new JButton("Load");
        bLoad.addActionListener(e -> handleLoadButtonClicked());
        
        bRefresh = new JButton("Refresh");
        bRefresh.addActionListener(e -> handleRefreshButtonClicked());
        
        bSave = new JButton("Save");
        bSave.addActionListener(e -> handleSaveButtonClicked());
        
        bDelete = new JButton("Delete");
        bDelete.addActionListener(e -> handleDeleteButtonClicked());
        
        bNew = new JButton("New");
        bNew.addActionListener(e -> handleNewButtonClicked());
        
    }
    
    public void initStatusBar() {
        
        statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        
        statusLabel = new JLabel("");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        
    }
    
    public void initLeftPanel() {
        
        leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        leftPanel.add(bNew);
        leftPanel.add(bLoad);
        leftPanel.add(bSave);
        leftPanel.add(bDelete);
        leftPanel.add(bRefresh);
    }
    
    public void initRightPanel() {
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Vertical
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rightPanel.add(lID);
        rightPanel.add(lNom);
        rightPanel.add(tfNom);
        rightPanel.add(lDesc);
        rightPanel.add(taDesc);
        
    }
    
    public void initLayout() {
        
        f.add(leftPanel, BorderLayout.WEST);
        f.add(rightPanel, BorderLayout.CENTER);
        f.add(statusPanel, BorderLayout.SOUTH);
        
    }
    
    // ************************************************************************
    
    // Handlers
    public void handleFieldChanged() { ctrl.modify(); }
    public void handleRefreshButtonClicked() { refresh(); }
    public void handleLoadButtonClicked()    { ctrl.load();}
    public void handleDeleteButtonClicked()  { ctrl.delete();}
    public void handleSaveButtonClicked()    { ctrl.save();}
    public void handleNewButtonClicked()     { ctrl.createNew();}
    
    
    public void refresh() {
        
        // Refresh text field
        tfNom.setText(ctrl.getCertification().getName());
        taDesc.setText(ctrl.getCertification().getDescription());
        
        // Handle saved/unsaved data
        if (ctrl.getCertification().getId() == NOT_IN_DB) {
            lID.setText("ID : Unsaved");
            bDelete.setEnabled(false);
        } else {
            lID.setText("ID : " + ctrl.getCertification().getId());
            bDelete.setEnabled(true);
        }
        
        changeStatusBar("Refresh");
        System.out.println(ctrl.getCertification());
    }
    
    // ************************************************************************
    
    public String getNom()                     { return tfNom.getText();}
    public String getDesc()                    { return taDesc.getText();}
    
    
    public void changeStatusBar(String status) { statusLabel.setText(status);}
    
    /** Macro pour savoir quand un champ est changer */
    public DocumentListener defaultFieldListener() {
        
        return new DocumentListener() {
            
            @Override
            public void removeUpdate(DocumentEvent e) { handleFieldChanged(); }
            @Override
            public void insertUpdate(DocumentEvent e) { handleFieldChanged(); }
            @Override
            public void changedUpdate(DocumentEvent arg0) { handleFieldChanged(); }
        };
    }
    
}
