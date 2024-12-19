package org.example.sae301objectaid;

import javafx.scene.control.Label;

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
    public void actualiser() {
        afficher(model.afficherFichiers());
    }

    public void afficher(String texte) {
        label.setText(texte);
    }
}
