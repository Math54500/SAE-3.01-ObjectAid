package org.example.sae301objectaid;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class VueClasses implements Observateur{
    private Model model ;

    public VueClasses(Model mod){
        this.model = mod ;
    }

    public void ajoutClasse(Class c){
       model.ajoutClasse(c) ;
    }

    @Override
    public void actualiser() {
    }

    public void afficher(){
        GraphicsContext gc = model.getCanvas().getGraphicsContext2D() ;
        for (DessinClasse dessinClasse : model.getDessinClasses()){
            dessinClasse.dessinerClasse(gc);
        }
    }
}
