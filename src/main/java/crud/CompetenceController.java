package crud;

import domain.Competence;
import model.RHModel;

import javax.swing.*;

public class CompetenceController implements CRUDController {
    
    private              Competence     competence = new Competence();
    private              CompetenceView view;
    
    public static void main(String[] args) throws ClassNotFoundException { new CompetenceController().run(); }
    
    public void run() throws ClassNotFoundException {
        
        loadDatabase();
        view = new CompetenceView(this);
        
        view.setController(this);
        
        view.run();
    }
    
    @Override
    public Competence getObj() { return competence; }
    
    @Override
    public CRUDView getView() { return view; }
    
    @Override
    public String idToString() { return Integer.toString(competence.getId());}
    

    
    // CRUD OPERATIONS ********************************************************
    
    public void modify() {
        
        getObj().setName(view.getNom());
        getObj().setDescription(view.getDesc());
        getObj().setCertification(RHModel.loadCertification(view.getCertificationID()));
        
        view.changeStatusBar("Modified");
    }
    
    public void save() {
        
        if (objectDoesNotExistInDB()) RHModel.create(competence);
        else RHModel.update(competence);
        
        view.refresh();
        view.changeStatusBar("Saved");
    }
    
    public void load() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("What id to load ?"));
        competence = RHModel.loadCompetence(id);
        
        if (objectExistInDB()) {
            view.changeStatusBar("Loaded");
        } else {
            view.changeStatusBar("ID not found");
        }
        view.refresh();
    }
    
    public void createNew() {
        
        competence = new Competence();
        view.refresh();
        view.changeStatusBar("New");
    }
    
    public void delete() {
        
        if (objectExistInDB()) {
            
            RHModel.delete(getObj());
            createNew();
            view.changeStatusBar("Deleted");
        } else
            view.changeStatusBar("Could not delete because it doesn't exist");

    }
}
