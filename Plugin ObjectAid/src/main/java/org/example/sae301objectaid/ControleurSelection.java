package org.example.sae301objectaid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class ControleurSelection implements EventHandler<MouseEvent> {

    private Model model;


    /**
     * @param model
     * Initialise le model
     */
    public ControleurSelection(Model model) {
        this.model = model;
    }

    /**
     * @param m
     * Le handler
     */
    @Override
    public void handle(MouseEvent m) {

        TreeView<String> treeView = (TreeView<String>) m.getSource();
        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (selectedItem.getValue().contains(".class")) {
                String[] s1 = selectedItem.getValue().split("\\.") ;
                String s = s1[0] ;
                while (!Objects.equals(selectedItem.getParent().getValue(), "SAE-3.01-ObjectAid")){
                    s = selectedItem.getParent().getValue() + "." + s ;
                    selectedItem = selectedItem.getParent() ;
                }
                model.ajoutClasse(s);
                model.notifierObservateurs();
            }
        }

    }

}
