package crud;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public abstract class CRUDView {
    
    protected              CRUDController ctrl = null;
    protected static final int            MIN_WIDTH  = 400;
    protected static final int            MIN_HEIGHT = 100;
    protected              JFrame         f;
    protected              JLabel         lID = new JLabel();
    
    protected JPanel buttonPanel;
    protected JPanel dataPanel;
    protected JPanel statusPanel;
    protected JLabel statusLabel;
    
    protected JButton bRefresh;
    protected JButton bSave;
    protected JButton bDelete;
    protected JButton bNew;
    protected JButton bLoad;
    
    
    // ************************************************************************
    
    
    public CRUDController getController() {                return ctrl;    }
    public void setController(CRUDController ctrl) { this.ctrl = ctrl; }
    /** Main */
    
    public void run() {
        
        initFrame();
        changeStatusBar("Init");
    }
    
    public void initFrame() {
        
        f = new JFrame(getWindowTitle());
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
        
        initButtonPanel();
        initDataPanel();
        initStatusBar();
        
        initLayout();
    }
    
    public abstract String getWindowTitle();
    public abstract void initLabels();
    
    public abstract void initFields();
    
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
    
    public void initButtonPanel() {
        
        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        buttonPanel.add(bNew);
        buttonPanel.add(bLoad);
        buttonPanel.add(bSave);
        buttonPanel.add(bDelete);
        buttonPanel.add(bRefresh);
    }
    
    public abstract void initDataPanel();
    
    public void initLayout() {
        
        f.add(buttonPanel, BorderLayout.WEST);
        f.add(dataPanel, BorderLayout.CENTER);
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

        // Handle saved/unsaved data
        if (ctrl.isObjectExistInDB()) {
            lID.setText("ID : Unsaved");
            bDelete.setEnabled(false);
        } else {
            lID.setText("ID : " + ctrl.idToString());
            bDelete.setEnabled(true);
        }
    
        refreshInputField();
        changeStatusBar("Refresh");
        System.out.println(ctrl.getObj());
    }
    
    public abstract void refreshInputField();
    
    // ************************************************************************
    
    
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
