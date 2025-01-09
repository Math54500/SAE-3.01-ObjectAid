package org.example.sae301objectaid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class ControleurFlecheCreation implements EventHandler<MouseEvent> {

    private Model model;
    double x1 = -1 ;
    double y1 = -1 ;

    /**
     * @param model
     * Initialise le model
     */
    public ControleurFlecheCreation(Model model) {
        this.model = model;
    }

    /**
     * @param m
     * Le handler
     */
    @Override
    public void handle(MouseEvent m) {
        if (x1 == -1) {
            x1 = m.getX();
            y1 = m.getY();
            System.out.println("Début flèche");
        }
        else {
            model.ajoutFleche(x1, y1, m.getX(), m.getY());
            model.notifierObservateurs() ;
            System.out.println("Fin flèche");
            x1 = -1 ;
            y1 = -1 ;
        }
    }

}