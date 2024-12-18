package org.example.sae301objectaid;

import javafx.scene.control.Label;
import java.io.File;

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
        File f = new File("C:\\Users\\Maths\\Desktop\\SAE-3.01-ObjectAid\\Plugin ObjectAid\\src\\main\\java\\org\\example\\sae301objectaid");
        String texte = Tree.printDirectoryTree(f);
        label.setText(texte);
    }
}
