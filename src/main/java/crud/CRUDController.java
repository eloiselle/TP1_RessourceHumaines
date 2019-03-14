package crud;

import model.DBCreator;
import model.RHModel;
import utils.IdInterface;

import javax.swing.*;

/**
 CRUDController est une interface de controller generique reutilisable pour different type de donnees */
public interface CRUDController {
    
    void run() throws ClassNotFoundException;
    
    void modify();
    void save();
    void load();
    void createNew();
    boolean delete();
    
    IdInterface getObj();
    CRUDView getView();
    String idToString();
    
    // Default methods
    default boolean objectExistInDB()        { return getObj().getId() != 0;}
    default boolean objectDoesNotExistInDB() { return getObj().getId() == 0;}
    
    default void loadDatabase() throws ClassNotFoundException {
        
        RHModel.init();
        DBCreator.generateData();
        
    }
    
    default int inputId() { return Integer.parseInt(JOptionPane.showInputDialog("What id to load ?"));}
    
}
