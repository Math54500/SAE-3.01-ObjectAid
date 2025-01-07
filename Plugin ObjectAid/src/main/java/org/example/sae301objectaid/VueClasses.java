package org.example.sae301objectaid;

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
}
