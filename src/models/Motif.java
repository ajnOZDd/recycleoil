package models;

public class Motif {
    private int id;
    private String motif;

    public Motif(int id, String motif) {
        this.id = id;
        this.motif = motif;
    }

    public Motif(String motif) {
        this.motif = motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    // Getters and setters
}