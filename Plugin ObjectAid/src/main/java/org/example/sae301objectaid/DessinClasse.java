package org.example.sae301objectaid;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DessinClasse {
    private int x;
    private int y;
    private Class classe;

    public DessinClasse(int x, int y, Class c, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        int y2 = y;
        this.classe = c;
        gc.strokeRect(x,y, 30, 90);
        Text nomClasse = new Text("Nom classe");
        gc.fillText(nomClasse.getText(), x, y);
        gc.strokeLine(x, y+10, x+30, y+10);
        for (int i=0; i<2; i++) {
            Text attribut = new Text("Attribut " + i);
            gc.fillText(attribut.getText(), x, y2+10);
            y2 += 10;
        }
        gc.strokeLine(x, y+50, x+30, y+50);
        for (int i=0; i<2; i++) {
            Text methode = new Text("Methode " + i);
            gc.fillText(methode.getText(), x, y2+10);
            y2 += 10;
        }
    }
}

