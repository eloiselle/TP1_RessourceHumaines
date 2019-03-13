package crud;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 CRUDView est une view generique reutilisable pour plusieurs type de donnees */
public abstract class CRUDView {
    
    private              JFrame         f;
    private              CRUDController ctrl       = null;
    private static final int            MIN_WIDTH  = 400;
    private static final int            MIN_HEIGHT = 100;
    
    JLabel lID = new JLabel();
    private JPanel dataPanel;
    private JPanel buttonPanel;
    private JPanel statusPanel;
    private JLabel statusLabel;
    
    private JButton bRefresh;
    private JButton bSave;
    private JButton bDelete;
    private JButton bNew;
    private JButton bLoad;
    
    // ************************************************************************
    
    // Abstract
    public abstract String getWindowTitle();
    public abstract void initElements();
    public abstract void refreshInputField();
    
    // Handlers
    private void handleFieldChanged() { ctrl.modify(); }
    private void handleRefreshButtonClicked() {
                                                  refresh();
                                                  changeStatusBar("Refresh");
                                              }
    private void handleLoadButtonClicked()    { ctrl.load();}
    private void handleDeleteButtonClicked()  { ctrl.delete();}
    private void handleSaveButtonClicked()    { ctrl.save();}
    private void handleNewButtonClicked()     { ctrl.createNew();}
    
    
    void changeStatusBar(String status)       { statusLabel.setText(status);}
    
    void setController(CRUDController ctrl)   { this.ctrl = ctrl; }
    
    /** Main */
    void run() {
        
        initFrame();
        changeStatusBar("Init");
    }
    
    private void initFrame() {
        
        f = new JFrame(getWindowTitle());
        initFrameElements();
        initFrameProperties();
        //refresh();
    }
    
    private void initFrameProperties() {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        f.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        f.pack();
        f.setLocationRelativeTo(null);  // Center window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    
    private void initFrameElements() {
        
        initButtons();
        initButtonPanel();
        initDataPanel();
        initElements();
        initStatusBar();
        
        initLayout();
    }
    
    
    private void initButtons() {
        
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
    
    private void initStatusBar() {
        
        statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        
        statusLabel = new JLabel("");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        
    }
    
    private void initButtonPanel() {
        
        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        buttonPanel.add(bNew);
        buttonPanel.add(bLoad);
        buttonPanel.add(bSave);
        buttonPanel.add(bDelete);
        buttonPanel.add(bRefresh);
    }
    
    private void initDataPanel() {
        
        dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS)); // Vertical
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    
    private void initLayout() {
        
        f.add(buttonPanel, BorderLayout.NORTH);
        f.add(dataPanel, BorderLayout.CENTER);
        f.add(statusPanel, BorderLayout.SOUTH);
        
    }
    
    // ************************************************************************
    
    
    void refresh() {
        
        // Handle saved/unsaved data
        if (ctrl.objectDoesNotExistInDB()) {
            lID.setText("ID : Unsaved");
            bDelete.setEnabled(false);
        } else {
            lID.setText("ID : " + ctrl.idToString());
            bDelete.setEnabled(true);
        }
        
        refreshInputField();
        System.out.println(ctrl.getObj());
    }
    
    // NEW DATA FIELD *********************************************************
    
    JLabel newLabel(String text) {
        
        JLabel label = new JLabel(text);
        dataPanel.add(label);
        return label;
    }
    
    JTextField newTextField(String label) {
        
        newLabel(label);
        JTextField textField = new JTextField();
        textField.getDocument().addDocumentListener(defaultFieldListener());
        dataPanel.add(textField);
        return textField;
    }
    
    JTextArea newTextArea(String label) {
        
        newLabel(label);
        JTextArea textArea = new JTextArea();
        textArea.setRows(5);
        textArea.getDocument().addDocumentListener(defaultFieldListener());
        dataPanel.add(textArea);
        return textArea;
    }
    
    
    /** Macro pour savoir quand un champ est changer */
    private DocumentListener defaultFieldListener() {
        
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
