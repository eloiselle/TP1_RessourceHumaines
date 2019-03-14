package crud;

import domain.Competence;
import model.RHModel;

public class CompetenceController implements CRUDController {
    
    private Competence     competence = new Competence();
    private CompetenceView view;
    
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
    }
    
    public void save() {
        
        if (objectDoesNotExistInDB()) RHModel.create(competence);
        else RHModel.update(competence);
        
        view.refresh();
    }
    
    public void load() {
        
        competence = RHModel.loadCompetence(inputId());
        view.refresh();
    }
    
    public void createNew() {
        
        competence = new Competence();
        view.refresh();
    }
    
    public boolean delete() {
        
        if (objectExistInDB()) {
            
            RHModel.delete(getObj());
            createNew();
            return true;
        } else return false;
        
    }
}
