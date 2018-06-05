
package hu.javalife.heroesofempires.herospecies.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hybrid")
public class Hybrid {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private byte percent;
    
    private long speciesid;
    
    private long heroid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getPercent() {
        return percent;
    }

    public void setPercent(byte percent) {
        this.percent = percent;
    }

    public long getSpeciesid() {
        return speciesid;
    }

    public void setSpeciesid(long speciesid) {
        this.speciesid = speciesid;
    }

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    
    
    
}
