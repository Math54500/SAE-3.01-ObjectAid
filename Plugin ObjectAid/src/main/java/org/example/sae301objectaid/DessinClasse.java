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

    public DessinClasse(double x, double y, Class c) {
        this.x = x;
        this.y = y;
        this.classe = c ;
    }

    public void dessinerClasse(GraphicsContext gc){
        double y2 = y;
        int hauteurTexte = 10 ;
        int largeur = 150 ;
        Text nomClasse = new Text(classe.getSimpleName());
        y2 += hauteurTexte ;
        gc.fillText(nomClasse.getText(), x+(largeur/nomClasse.getText().length()), y2);
        y2 += 5 ;
        gc.strokeLine(x, y2, x+largeur, y2);
        y2 += 2 ;
        for (Field field : classe.getDeclaredFields()) {
            Text attribut = new Text(field.getName());
            gc.fillText(attribut.getText(), x+(largeur/attribut.getText().length()), y2+hauteurTexte);
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

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

