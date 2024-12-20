package org.example.sae301objectaid;

public class VueClasses implements Observateur{
    private Model model ;
    private DessinClasse dessinClasse ;

    public VueClasses(Model mod){
        this.model = mod ;
    }

    public void ajoutClasse(Class c){
        this.dessinClasse = new DessinClasse(20, 20, c, model.getCanvas().getGraphicsContext2D()) ;
    }

    @Override
    public void actualiser() {
    }
}
