package org.example.sae301objectaid;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class VueAfficheur implements Observateur{
    private Model model ;
    private TreeItem arbre ;

    /**
     * @param mod
     * Initialise le paramètre model
     */
    public VueAfficheur(Model mod){
        this.model = mod ;
    }

    /**
     * @param l
     * Initialise le paramètre arbre
     */
    public void ajoutArbre(TreeItem l){
        this.arbre = l ;
    }

    /**
     * Actualise
     */
    @Override
    public void actualiser() {
        afficher(model.afficherFichiers());
    }

    /**
     * @param arb
     * Afficher les "Enfants" de l'arbre
     */
    public void afficher(TreeItem arb) {
        arbre.getChildren().add(arb);
    }
}
