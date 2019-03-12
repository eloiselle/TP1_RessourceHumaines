package crud;

import javax.swing.*;
import java.awt.*;

public class CompetenceView extends CRUDView {
    
    private              CompetenceController ctrl;
    private static final String               TITLE = "Head Hunter - Competence";
    
    private JLabel lNom;
    private JLabel lDesc;
    private JLabel lCertification;
    
    private JTextField tfNom;
    private JTextArea  taDesc;
    private JTextField tfCertification;
    
    
    // INIT *******************************************************************
    
    CompetenceView(CompetenceController controller) { this.ctrl = controller; }
    
    
    @Override
    public void initLabels() {
        
        lID = new JLabel("ID : <default>");
        lNom = new JLabel("Nom : ");
        lDesc = new JLabel("Description : ");
        lCertification = new JLabel("Certification ID : ");
    }
    
    @Override
    public void initFields() {
        
        tfNom = new JTextField();
        tfNom.getDocument().addDocumentListener(defaultFieldListener());

        taDesc = new JTextArea();
        taDesc.setRows(5);
        taDesc.getDocument().addDocumentListener(defaultFieldListener());
        
        tfCertification = new JTextField();
        tfCertification.getDocument().addDocumentListener(defaultFieldListener());
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
        dataPanel.add(lCertification);
        dataPanel.add(tfCertification);
    }
    
    @Override
    public String getWindowTitle(){ return TITLE;}
    
    // REFRESH INPUT FIELD ****************************************************
    
    @Override
    public void refreshInputField() {
    
        tfNom.setText(ctrl.getObj().getName());
        taDesc.setText(ctrl.getObj().getDescription());
        tfCertification.setText(Integer.toString(ctrl.getObj().getCertification().getId()));
    }
    
    // OBJECT PROPERTIES ******************************************************
    
    String getNom()  { return tfNom.getText();}
    String getDesc() { return taDesc.getText();}
    int getCertificationID() { return Integer.parseInt(tfCertification.getText());}
    
    
}
