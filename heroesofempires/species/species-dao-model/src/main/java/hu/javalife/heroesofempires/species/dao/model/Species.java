package hu.javalife.heroesofempires.species.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author user
 */
@Entity
@Table(name = "species")
@NamedQueries({
    @NamedQuery(name = "Species.name", query = "SELECT s FROM Species s WHERE s.name=:name")
})
public class Species {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
           
    private String name;
    
    @Column(name = "descrip", length = 50)
    private String description;

    public Species() {
    }
    
    
    public Species(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
       

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Species other = (Species) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
