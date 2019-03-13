package crud;

import javax.swing.*;

public class CompetenceView extends CRUDView {
    
    private              CompetenceController ctrl;
    private static final String               TITLE = "Head Hunter - Competence";
    
    private JTextField tfNom;
    private JTextArea  taDesc;
    private JTextField tfCertification;
    
    
    // INIT *******************************************************************
    
    CompetenceView(CompetenceController controller) { this.ctrl = controller; }
    
    
    @Override
    public void initElements() {
        
        lID = newLabel("ID : <default>");
        tfNom = newTextField("Nom");
        taDesc = newTextArea("Description");
        tfCertification = newTextField("Certification ID");
    }
    
    @Override
    public String getWindowTitle() { return TITLE;}
    
    
    @Override
    public void refreshInputField() {
        
        tfNom.setText(ctrl.getObj().getName());
        taDesc.setText(ctrl.getObj().getDescription());
        
        int certification_id = ctrl.getObj().getCertification().getId();
        tfCertification.setText(Integer.toString(certification_id));
    }
    
    // OBJECT PROPERTIES ******************************************************
    
    String getNom()          { return tfNom.getText();}
    String getDesc()         { return taDesc.getText();}
    int getCertificationID() { return Integer.parseInt(tfCertification.getText());}
    
    
}
