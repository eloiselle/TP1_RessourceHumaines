package crud;

import domain.Certification;
import model.RHModel;

import javax.swing.*;

public class CertificationController implements CRUDController {
    
    private static final int               NOT_IN_DB     = 0;
    private              Certification     certification = new Certification();
    private              CertificationView view;
    
    public static void main(String[] args) throws ClassNotFoundException { new CertificationController().run(); }
    
    public void run() throws ClassNotFoundException {
        
        loadDatabase();
        view = new CertificationView(this);
        
        view.setController(this);
        
        view.run();
    }
    
    @Override
    public Certification getObj() { return certification; }
    
    @Override
    public String idToString() { return Integer.toString(certification.getId());}
    
    @Override
    public boolean isObjectExistInDB() { return getObj().getId() == NOT_IN_DB;}
    
    // CRUD OPERATIONS ********************************************************
    
    public void modify() {
        
        getObj().setName(view.getNom());
        getObj().setDescription(view.getDesc());
        
        view.changeStatusBar("Modified");
    }
    
    public void save() {
        
        if (certification.getId() == 0) RHModel.create(certification);
        else RHModel.update(certification);
        
        view.refresh();
        view.changeStatusBar("Saved");
    }
    
    public void load() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("What id to load ?"));
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
