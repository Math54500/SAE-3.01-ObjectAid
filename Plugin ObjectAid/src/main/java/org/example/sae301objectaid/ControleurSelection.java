package org.example.sae301objectaid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class ControleurSelection implements EventHandler<MouseEvent> {

    private Model model;

    public ControleurSelection(Model model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent m) {

        TreeView<String> treeView = (TreeView<String>) m.getSource();
        System.out.println(treeView.getSelectionModel().getSelectedItem().getValue());

    }

}
