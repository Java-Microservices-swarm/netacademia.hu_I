package hu.javalife.heroesofempires.hero.rest;

/**
 * @author user
 */
public class Hero {
    private String name, description;

    public Hero(){}
    
    public Hero(String name, String description) {
        this.name = name;
        this.description = description;
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
    
    
}
