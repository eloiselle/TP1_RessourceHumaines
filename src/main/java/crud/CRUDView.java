package crud;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public abstract class CRUDView {
    
    private              CRUDController ctrl       = null;
    private static final int            MIN_WIDTH  = 400;
    private static final int            MIN_HEIGHT = 100;
    private              JFrame         f;
    
    JLabel lID = new JLabel();
    JPanel dataPanel;
    private JPanel buttonPanel;
    private JPanel statusPanel;
    private JLabel statusLabel;
    
    private JButton bRefresh;
    private JButton bSave;
    private JButton bDelete;
    private JButton bNew;
    private JButton bLoad;
    
    
    // ************************************************************************
    
    
    void setController(CRUDController ctrl) { this.ctrl = ctrl; }
    
    /** Main */
    void run() {
        
        initFrame();
        changeStatusBar("Init");
    }
    
    private void initFrame() {
        
        f = new JFrame(getWindowTitle());
        initFrameElements();
        initFrameProperties();
        refresh();
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
        
        initLabels();
        initButtons();
        initFields();
        
        initButtonPanel();
        initDataPanel();
        initStatusBar();
        
        initLayout();
    }
    
    public abstract String getWindowTitle();
    public abstract void initLabels();
    
    public abstract void initFields();
    
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
    
    public abstract void initDataPanel();
    
    private void initLayout() {
        
        f.add(buttonPanel, BorderLayout.NORTH);
        f.add(dataPanel, BorderLayout.CENTER);
        f.add(statusPanel, BorderLayout.SOUTH);
        
    }
    
    // ************************************************************************
    
    // Handlers
    private void handleFieldChanged() { ctrl.modify(); }
    private void handleRefreshButtonClicked() { refresh(); changeStatusBar("Refresh");}
    private void handleLoadButtonClicked()    { ctrl.load();}
    private void handleDeleteButtonClicked()  { ctrl.delete();}
    private void handleSaveButtonClicked()    { ctrl.save();}
    private void handleNewButtonClicked()     { ctrl.createNew();}
    
    
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
    
    public abstract void refreshInputField();
    
    // ************************************************************************
    
    
    void changeStatusBar(String status) { statusLabel.setText(status);}
    
    /** Macro pour savoir quand un champ est changer */
    DocumentListener defaultFieldListener() {
        
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
