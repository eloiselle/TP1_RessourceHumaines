package launcher;

import domain.Certification;
import model.DBCreator;
import model.RHModel;

import javax.swing.*;

public class CertificationController {
    
    private static final int               NOT_IN_DB     = 0;
    private              Certification     certification = new Certification();
    private              CertificationView view;
    
    public static void main(String[] args) throws ClassNotFoundException { new CertificationController().run(); }
    
    public void run() throws ClassNotFoundException {
        
        RHModel.init();
        DBCreator.generateData();
        
        view = new CertificationView(this);
        view.run();
    }
    
    public Certification getCertification() { return certification; }
    
    // ************************************************************************
    
    public void modify() {
        
        getCertification().setName(view.getNom());
        getCertification().setDescription(view.getDesc());
        view.changeStatusBar("Modified");
    }
    
    public void save() {
        
        if (certification.getId() == 0) RHModel.create(certification);
        else RHModel.update(certification);
        
        view.refresh();
        view.changeStatusBar("Saved");
    }
    
    public void load() {
        
        String answer = JOptionPane.showInputDialog("What id to load ?");
        int    id     = Integer.parseInt(answer);
        certification = RHModel.loadCertification(id);
        
        if (certification.getId() == NOT_IN_DB) {
            view.changeStatusBar("ID not found");
        } else {
            view.refresh();
            view.changeStatusBar("Loaded");
        }
    }
    
    public void createNew() {
        
        certification = new Certification();
        view.refresh();
        view.changeStatusBar("New");
    }
    
    public void delete() {
        
        // Handle ID not existing
        if (certification.getId() == NOT_IN_DB) {
            view.changeStatusBar("Could not delete");
            return;
        }
        
        // Delete
        RHModel.delete(certification);
        createNew();
        view.changeStatusBar("Deleted");
    }
}
