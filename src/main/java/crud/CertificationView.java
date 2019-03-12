package crud;

import javax.swing.*;
import java.awt.*;

public class CertificationView extends CRUDView {
    
    private              CertificationController ctrl;
    private static final String                  TITLE = "Head Hunter - Certification";
    
    private JLabel lNom;
    private JLabel lDesc;
    
    private JTextField tfNom;
    private JTextArea  taDesc;
    
    
    // INIT *******************************************************************
    
    CertificationView(CertificationController controller) { this.ctrl = controller; }
    
    
    @Override
    public void initLabels() {
        
        lID = new JLabel("ID : <default>");
        lNom = new JLabel("Nom : ");
        lDesc = new JLabel("Description : ");
    }
    
    @Override
    public void initFields() {
        
        tfNom = new JTextField();
        tfNom.getDocument().addDocumentListener(defaultFieldListener());

        taDesc = new JTextArea();
        taDesc.setRows(5);
        taDesc.getDocument().addDocumentListener(defaultFieldListener());
    }
    
    @Override
    public void initDataPanel() {
        
        dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS)); // Vertical
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dataPanel.add(lID);
        dataPanel.add(lNom);
        dataPanel.add(tfNom);
        dataPanel.add(lDesc);
        dataPanel.add(taDesc);
    }
    
    @Override
    public String getWindowTitle(){ return TITLE;}
    
    // REFRESH INPUT FIELD ****************************************************
    
    @Override
    public void refreshInputField() {
    
        tfNom.setText(ctrl.getObj().getName());
        taDesc.setText(ctrl.getObj().getDescription());
        
    }
    
    // OBJECT PROPERTIES ******************************************************
    
    String getNom()  { return tfNom.getText();}
    String getDesc() { return taDesc.getText();}
    
    
}
