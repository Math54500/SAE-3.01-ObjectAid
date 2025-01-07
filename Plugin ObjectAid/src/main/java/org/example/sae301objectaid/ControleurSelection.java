package org.example.sae301objectaid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurSelection implements EventHandler<ActionEvent> {

    private Model model;

    public ControleurSelection(Model model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent e) {

        System.out.println("poutre de castor");

    }
}
