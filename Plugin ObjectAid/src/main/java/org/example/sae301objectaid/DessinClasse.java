package org.example.sae301objectaid;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DessinClasse {
    private double x;
    private double y;
    private Class classe;

    /**
     * @param x La position x
     * @param y La position y
     * @param c La classe
     * Constructeur
     */
    public DessinClasse(double x, double y, Class c) {
        this.x = x;
        this.y = y;
        this.classe = c ;
    }

    /**
     * @param gc
     * Permet de dessiner le diagramme d'une classe
     */
    public void dessiner(GraphicsContext gc){
        double y2 = y;
        int hauteurTexte = 10 ;
        int largeur = 150 ;
        Text nomClasse = new Text(classe.getSimpleName());
        y2 += hauteurTexte ;
        gc.fillText(nomClasse.getText(), x+(largeur/nomClasse.getText().length())/2, y2);
        y2 += 5 ;
        gc.strokeLine(x, y2, x+largeur, y2);
        y2 += 2 ;
        for (Field field : classe.getDeclaredFields()) {
            Text attribut = new Text(field.getName());
            gc.fillText(attribut.getText(), x+(largeur/attribut.getText().length())/2, y2+hauteurTexte);
            y2 += hauteurTexte;
        }
        y2 += 5 ;
        gc.strokeLine(x, y2, x+largeur, y2);
        y2 += 2 ;
        for (Method method : classe.getMethods()) {
            Text methode = new Text(method.getName());
            gc.fillText(methode.getText(), x+(largeur/methode.getText().length()), y2+hauteurTexte);
            y2 += hauteurTexte;
        }
        y2 -= (y-5) ;
        gc.strokeRect(x,y, largeur, y2);
    }


    /**
     * @return La valeur de X
     */
    public double getX() {
        return x;
    }

    /**
     * @param x
     * Setter de X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return La valeur de Y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y
     * Setter de Y
     */
    public void setY(int y) {
        this.y = y;
    }
}

