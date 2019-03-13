package crud;

import domain.Certification;
import model.RHModel;

import javax.swing.*;

public class CertificationController implements CRUDController {
    
    private Certification     certification = new Certification();
    private CertificationView view;
    
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
    public CRUDView getView() { return view; }
    
    @Override
    public String idToString() { return Integer.toString(certification.getId());}
    
    
    // CRUD OPERATIONS ********************************************************
    
    public void modify() {
        
        getObj().setName(view.getNom());
        getObj().setDescription(view.getDesc());
        
        view.changeStatusBar("Modified");
    }
    
    public void save() {
        
        if (objectDoesNotExistInDB()) RHModel.create(certification);
        else RHModel.update(certification);
        
        view.refresh();
        view.changeStatusBar("Saved");
    }
    
    public void load() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("What id to load ?"));
        certification = RHModel.loadCertification(id);
        
        view.refresh();
        
        if (objectExistInDB()) {
            view.changeStatusBar("Loaded");
        } else {
            view.changeStatusBar("ID not found");
        }
    }
    
    public void createNew() {
        
        certification = new Certification();
        view.refresh();
        view.changeStatusBar("New");
    }
    
    public void delete() {
        
        if (objectExistInDB()) {
            
            RHModel.delete(getObj());
            createNew();
            view.changeStatusBar("Deleted");
            
        } else view.changeStatusBar("Could not delete because it doesn't exist");
    }
}
