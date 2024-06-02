package models;

import java.util.Date;

public class Absence {
    private int id;
    private int id_Personnel;
    private Date date_Absence;
    private Motif id_Motif;


    public Absence(int id, int id_Personnel, Date date_Absence, Motif id_Motif) {
        this.id = id;
        this.id_Personnel = id_Personnel;
        this.date_Absence = date_Absence;
        this.id_Motif = id_Motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Personnel() {
        return id_Personnel;
    }

    public void setId_Personnel(int id_Personnel) {
        this.id_Personnel = id_Personnel;
    }

    public Date getDate_Absence() {
        return date_Absence;
    }

    public void setDate_Absence(Date date_Absence) {
        this.date_Absence = date_Absence;
    }

    public Motif getId_Motif() {
        return id_Motif;
    }

    public void setId_Motif(Motif id_Motif) {
        this.id_Motif = id_Motif;
    }

  
    // Getters and setters
}