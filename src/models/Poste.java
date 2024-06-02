package models;


public class Poste {
    private int id_Poste;
    private String poste;

    public Poste(int id_Poste, String poste) {
        this.id_Poste = id_Poste;
        this.poste = poste;
    }

    public int getId_Poste() {
        return id_Poste;
    }

    public void setId_Poste(int id_Poste) {
        this.id_Poste = id_Poste;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
    
   
}
