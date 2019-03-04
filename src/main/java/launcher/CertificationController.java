package launcher;

import domain.Certification;
import facade.RHModel;

public class CertificationController {
    
    Certification     certification = new Certification();
    CertificationView view;
    
    public static void main(String[] args) throws ClassNotFoundException { new CertificationController().run(); }
    
    public void run() throws ClassNotFoundException{
        
        view = new CertificationView(this);
        view.run();
    }
    
    public Certification getCertification() { return certification; }
    
    // ************************************************************************
    
    public void saveToObject() {
        
        getCertification().setName(view.getNom());
        getCertification().setDescription(view.getDesc());
    }
    
    public void saveToDB() {
        
        if (certification.getId() == 0)
            RHModel.create(certification);
        else
            RHModel.update(certification);
    
    }
    public void delete()   { RHModel.delete(certification); }
}
