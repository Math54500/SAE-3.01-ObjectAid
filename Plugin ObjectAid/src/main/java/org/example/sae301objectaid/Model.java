package org.example.sae301objectaid;

import javafx.scene.canvas.Canvas;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model implements Sujet {
    private final List<Observateur> observateurs ;
    private Canvas canvas ;
    private ArrayList<DessinClasse> dessinClasses = new ArrayList<>() ;
    private ArrayList<DessinFleche> dessinFleches = new ArrayList<>() ;
    private Tree arbre;


    public Model() {
        this.observateurs = new ArrayList<Observateur>();
    }

    public void enregistrerObservateur(Observateur observateur) {
        this.observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        this.observateurs.remove(observateur);
    }

    public void notifierObservateurs() {
        for (Observateur observateur : this.observateurs) {
            observateur.actualiser();
        }
    }

    public TreeItem afficherFichiers(){
        File f = new File(".\\out\\production\\SAE-3.01-ObjectAid");
        return Tree.creerArbre(f);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas cvs) {
        this.canvas = cvs ;
    }

    public void ajoutClasse(String s){
        try {
            double x = Math.random() * (canvas.getWidth() - 150);
            double y = Math.random() * (canvas.getHeight() - 150);
            Class<?> c = Class.forName(s);
            for (DessinClasse dessinClasse : dessinClasses) {
                while (dessinClasse.getX() - 200 < x && x < dessinClasse.getX() + 150 && dessinClasse.getY() - 150 < y && y < dessinClasse.getY() + 150) {
                    x = Math.random() * (canvas.getWidth() - 150);
                    y = Math.random() * (canvas.getHeight() - 150);
                }
            }
            if (dessinClasses.size()<5){
                this.dessinClasses.add(new DessinClasse(x, y, c));
            }
        } catch (ClassNotFoundException e){
            throw new RuntimeException() ;
        }
    }

    public ArrayList<DessinClasse> getDessinClasses() {
        return dessinClasses ;
    }

    public ArrayList<DessinFleche> getDessinFleches() {
        return dessinFleches ;
    }
}