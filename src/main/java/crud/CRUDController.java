package crud;

import model.DBCreator;
import model.RHModel;
import utils.IdInterface;


public interface CRUDController {
    
    void run() throws ClassNotFoundException;
    
    void modify();
    void save();
    void load();
    void createNew();
    void delete();
    
    IdInterface getObj();
    
    String idToString();
    boolean isObjectExistInDB();
    
    default void loadDatabase() throws ClassNotFoundException {
        
        RHModel.init();
        DBCreator.generateData();
        
    }

}
