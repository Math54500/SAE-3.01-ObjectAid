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
     * Actualise
     */
    @Override
    public void actualiser() {
        this.afficher() ;
    }

    /**
     * Permet d'afficher toutes les classes
     */
    public void afficher(){
        GraphicsContext gc = model.getCanvas().getGraphicsContext2D() ;
        for (DessinClasse dessinClasse : model.getDessinClasses()){
            dessinClasse.dessiner(gc);
        }
        for (DessinFleche dessinFleche : model.getDessinFleches()){
            dessinFleche.dessiner(gc) ;
        }
    }
}
