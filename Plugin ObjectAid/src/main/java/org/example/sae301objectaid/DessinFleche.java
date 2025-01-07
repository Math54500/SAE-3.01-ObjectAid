package org.example.sae301objectaid;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class DessinFleche {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DessinFleche(int x1, int y1, int x2, int y2, GraphicsContext gc) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;


        gc.setFill(Color.BLACK);
        gc.strokeLine(x1, y1, x2, y2);
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy);

        Transform transform = Transform.translate(x1, y1);
        transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
        gc.setTransform(new Affine(transform));


        gc.fillPolygon(new double[]{len, len - 8, len - 8, len}, new double[]{0, -8, 8, 0}, 4);
    }
}
