package org.example.sae301objectaid;

public class Objet {

    private String nom;

    public Objet(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
