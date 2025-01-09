package org.example.sae301objectaid;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class DessinFleche {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    /**
     * @param x1 Position X de départ
     * @param y1 Position Y de départ
     * @param x2 Position X de fin
     * @param y2 Position Y de fin
     * Permet de créer une flèche
     */
    public DessinFleche(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void dessiner(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.strokeLine(x1, y1, x2, y2);
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy);

        Transform transform = Transform.translate(x1, y1);
        transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
        gc.setTransform(new Affine(transform));


        gc.fillPolygon(new double[]{len, len - 8, len - 8, len}, new double[]{0, -8, 8, 0}, 4);

        gc.setTransform(new Affine());
    }
}
