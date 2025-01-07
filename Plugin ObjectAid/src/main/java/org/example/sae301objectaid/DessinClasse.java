package org.example.sae301objectaid;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DessinClasse {
    private int x;
    private int y;
    private Class classe;

    public DessinClasse(int x, int y, Class c, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        int y2 = y;
        int hauteurTexte = 10 ;
        this.classe = c;
        Text nomClasse = new Text(classe.getSimpleName());
        y2 += hauteurTexte ;
        gc.fillText(nomClasse.getText(), x+(100.0/nomClasse.getText().length()), y2);
        y2 += 5 ;
        gc.strokeLine(x, y2, x+100, y2);
        y2 += 2 ;
        for (Field field : classe.getDeclaredFields()) {
            Text attribut = new Text(field.getName());
            gc.fillText(attribut.getText(), x+(100.0/attribut.getText().length()), y2+hauteurTexte);
            y2 += hauteurTexte;
        }
        y2 += 5 ;
        gc.strokeLine(x, y2, x+100, y2);
        y2 += 2 ;
        for (Method method : classe.getMethods()) {
            Text methode = new Text(method.getName());
            gc.fillText(methode.getText(), x+(100.0/methode.getText().length()), y2+hauteurTexte);
            y2 += hauteurTexte;
        }
        y2 -= (y-5) ;
        gc.strokeRect(x,y, 100, y2);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

