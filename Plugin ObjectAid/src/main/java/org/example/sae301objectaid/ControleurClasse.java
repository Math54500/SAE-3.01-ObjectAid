package org.example.sae301objectaid;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControleurClasse implements EventHandler<MouseEvent> {

    private Model model;

    public ControleurClasse(Model model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        for (DessinClasse dess : model.getDessinClasses()) {
            System.out.println("patate");
        }
    }
}
