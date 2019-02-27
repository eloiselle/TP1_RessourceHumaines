package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @Column(name = "id_application")
    private int id;
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name = "cv_path") String cvPath;
    public String getCvPath()            { return cvPath; }
    public void setCvPath(String cvPath) { this.cvPath = cvPath; }
    

}
