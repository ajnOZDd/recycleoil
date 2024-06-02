package models;

import java.util.Date;

public class Personnel {
    private int id_Personnel;
    private Poste id_Poste;
    private String nom;
    private String prenom;
    private String email;
    private Date date_embauche;
    private double salaire;
    private String addresse;
    private String numero_telephone;
    private Date date_naissance;

    public Personnel(int id_Personnel, Poste id_Poste, String nom, String prenom, String email, Date date_embauche, double salaire, String addresse, String numero_telephone, Date date_naissance) {
        this.id_Personnel = id_Personnel;
        this.id_Poste = id_Poste;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_embauche = date_embauche;
        this.salaire = salaire;
        this.addresse = addresse;
        this.numero_telephone = numero_telephone;
        this.date_naissance = date_naissance;
    }

    public int getId_Personnel() {
        return id_Personnel;
    }

    public void setId_Personnel(int id_Personnel) {
        this.id_Personnel = id_Personnel;
    }

    public Poste getId_Poste() {
        return id_Poste;
    }

    public void setId_Poste(Poste id_Poste) {
        this.id_Poste = id_Poste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

 

    // Getters and setters
}