package org.example.sae301objectaid;

public class VueSelection implements Observateur{

    @Override
    public void actualiser(Sujet s) {
        System.out.println("poutre");
    }
}
