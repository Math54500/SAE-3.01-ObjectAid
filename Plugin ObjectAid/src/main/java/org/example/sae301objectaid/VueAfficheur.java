package org.example.sae301objectaid;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VueAfficheur implements Observateur{
    private Model model ;
    private Label label ;

    public VueAfficheur(Model mod){
        this.model = mod ;
    }

    public void ajoutLabel(Label l){
        this.label = l ;
    }

    @Override
    public void actualiser(Sujet sujet) {
        afficher();
    }

    public void afficher() {
        label.setText("poutre");
    }
}
