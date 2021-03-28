
package com.esprit.models;

/**
 *
 * @author Fayechi
 */
public class programme {
    private int id;
    private String difficulte;
    private String type;
    private int duree;
    private int progression;
    public programme() {
    }

    public programme(int id, String difficulte, String type, int duree, int progression) {
        this.id = id;
        this.difficulte = difficulte;
        this.type = type;
        this.duree = duree;
        this.progression = progression;
    }

    public programme(String difficulte, String type, int duree, int progression) {
        this.difficulte = difficulte;
        this.type = type;
        this.duree = duree;
        this.progression = progression;
    }

    public programme(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getDifficulte() {
        return difficulte;
    }
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
      @Override
    public String toString() {
        return "programme{" + "id=" + getId() + ", nom=" + getDifficulte() + ", prenom=" + getType() + '}';
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public int getProgression() {
        return progression;
    }
    public void setProgression(int progression) {
        this.progression = progression;
    }

    public void setId(int id) {
        this.id = id;
    }

   

}
