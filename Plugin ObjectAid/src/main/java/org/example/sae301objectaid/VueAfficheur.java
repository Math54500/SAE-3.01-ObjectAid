package org.example.sae301objectaid;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class VueAfficheur implements Observateur{
    private Model model ;
    private TreeItem arbre ;

    public VueAfficheur(Model mod){
        this.model = mod ;
    }

    public void ajoutArbre(TreeItem l){
        this.arbre = l ;
    }

    @Override
    public void actualiser() {
        afficher(model.afficherFichiers());
    }

    public void afficher(TreeItem arb) {
        arbre.getChildren().add(arb);
    }
}
