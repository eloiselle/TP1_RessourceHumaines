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
    CRUDView getView();
    
    String idToString();
    default boolean objectExistInDB() { return getObj().getId() != 0;}
    default boolean objectDoesNotExistInDB() { return getObj().getId() == 0;}
    
    default void loadDatabase() throws ClassNotFoundException {
        
        RHModel.init();
        DBCreator.generateData();
        
    }
    
    

}
