package crud;

import domain.Certification;
import model.RHModel;

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
    }
    
    public void save() {
        
        if (objectDoesNotExistInDB()) RHModel.create(certification);
        else RHModel.update(certification);
        
        view.refresh();
    }
    
    public void load() {
        
        certification = RHModel.loadCertification(inputId());
        view.refresh();
        
    }
    
    public void createNew() {
        
        certification = new Certification();
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
