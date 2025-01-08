package org.example.sae301objectaid;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class VueClasses implements Observateur{
    private Model model ;

    /**
     * @param mod
     * Initialise l'attribut model
     */
    public VueClasses(Model mod){
        this.model = mod ;
    }

    /**
     * @param c
     * Ajoute une classe au model
     */
    public void ajoutClasse(Class c){
       model.ajoutClasse(c) ;
    }

    /**
     * Fait que dalle
     */
    @Override
    public void actualiser() {
    }

    /**
     * Permet d'afficher toutes les classes
     */
    public void afficher(){
        GraphicsContext gc = model.getCanvas().getGraphicsContext2D() ;
        for (DessinClasse dessinClasse : model.getDessinClasses()){
            dessinClasse.dessinerClasse(gc);
        }
    }
}
