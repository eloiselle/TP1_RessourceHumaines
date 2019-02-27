package utils;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


import static java.lang.System.exit;

/**
 Interface demandee par le client */
public class PersistenceManager {
    
    private static final String               DRIVER                = "com.mysql.cj.jdbc.Driver";
    private static final String               PERSISTENCE_UNIT_NAME = "org.hibernate.tutorial.jpa";
    protected static     EntityManagerFactory emFactory;
    
    
    /** Execute a select query and return a List d'Object
    @param query Requete a faire passer
    @return List des objet en resultat de la requete
    */
    private static List <Object> selectQuery(String query) {
        
        return emFactory.createEntityManager().createQuery(query).getResultList();
    }
    
    /** Execute a select query and return a List d'Object
    @param query Requete a faire passer
    @return nombre d'element qui ont ete changer
    */
    private static int updateQuery(String query) {
        
        return emFactory.createEntityManager().createQuery(query).executeUpdate();
    }
    
    /** Initialise */
    public static void init() throws ClassNotFoundException {
        
        Class.forName(DRIVER);
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        System.out.println("Persistence initialization is complete.");
    }


    /** Ajoute un nouvel objet dans la database
     @param obj objet a creer dans la database
     @return si ca a reussi
     */
    public static boolean create(Object obj) {
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        return commit(em);
    }
    
    /** Essaye de mettre a jour l'objet a partir de la DB
     @param obj Objet a reloader
     @return vrai si c'est reussi     */
    public static boolean tryToRefresh(Object obj) {
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.refresh(obj);
        return commit(em);
    }
    
    
    /** Met un champ a jour dans la DB a partir de l'objet
     @param obj Objet a mettre a jour
     @return  objet mis a jour
     */
    public static Object update(Object obj) {
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        obj = em.merge(obj);
        
        commit(em);
        return obj;
        
    }

//    PEUT ETRE IMPLEMENTER SI ON CONNAIT D'AVANCE LA CLASSE
//    /** Essaye de supprimer un objet dans la DB */
//    public static boolean tryToDelete(MyClass obj) {
//
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        obj = em.find(MyClass.class, ((MyClass)obj).getId());
//        em.remove(obj);
//        return commit(em);
//    }


//    public static boolean myClassExist(int id) { return emFactory.createEntityManager().find(MyClass.class, id) != null; }
    
    
    /** Essaye de commiter et retourne si ca a marcher
     @param em EntityManager a utiliser pour faire le commit
     @return si ca a reussi
     */
    protected static boolean commit(EntityManager em){
        
        boolean isSuccess = false;
        
        try {
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            exit(0);
        } finally {
            em.close();
        }
        return isSuccess;
    }
    
    /** Vide la table de toutes les donnees
     @param tableName
     */
    public static void clearTable(String database, String tableName){
        updateQuery("TRUNCATE `" + database + "`.`" + tableName+"`;");
    }
    
    /** Ferme la emFactory */
    public static void close() { emFactory.close(); }
    
}
