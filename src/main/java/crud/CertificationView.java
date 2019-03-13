package crud;

import javax.swing.*;
import java.awt.*;

public class CertificationView extends CRUDView {
    
    private              CertificationController ctrl;
    private static final String                  TITLE = "Head Hunter - Certification";
    
    private JTextField tfNom;
    private JTextArea  taDesc;
    
    
    // INIT *******************************************************************
    
    CertificationView(CertificationController controller) { this.ctrl = controller; }
    
    
    @Override
    public void initElements() {
        
        lID = newLabel("ID : <default>");
        tfNom = newTextField("Nom");
        taDesc = newTextArea("Description");
    }
    
    
    @Override
    public String getWindowTitle() { return TITLE;}
    
    
    @Override
    public void refreshInputField() {
        
        tfNom.setText(ctrl.getObj().getName());
        taDesc.setText(ctrl.getObj().getDescription());
        
    }
    
    // OBJECT PROPERTIES ******************************************************
    
    String getNom()  { return tfNom.getText();}
    String getDesc() { return taDesc.getText();}
    
    
}
