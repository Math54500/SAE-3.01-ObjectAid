package org.example.sae301objectaid;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Model model = new Model() ;
        VueAfficheur vueAfficheur = new VueAfficheur(model) ;
        VueClasses vueClasses = new VueClasses(model) ;
        model.enregistrerObservateur(vueAfficheur) ;
        model.enregistrerObservateur(vueClasses) ;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        GridPane pane = new GridPane();
        Label label = new Label("Afficheur de fichier");
        Label label2 = new Label("Espace dessinable");
        VBox vBox = new VBox();

        ControleurSelection controleurSelection = new ControleurSelection(model) ;
        TreeView<String> arbreView = new TreeView<>(model.afficherFichiers());
        arbreView.setOnMouseClicked(controleurSelection);
        vueAfficheur.ajoutArbre(model.afficherFichiers());

        Canvas canvas  = new Canvas(600, 400);
        model.setCanvas(canvas);
        pane.setGridLinesVisible(true);
        pane.add(label, 0, 0);
        pane.add(label2, 1, 0);
        pane.add(arbreView, 0, 1);
        pane.add(canvas, 1,1);
        pane.getColumnConstraints().add(new ColumnConstraints(300));
        pane.getColumnConstraints().add(new ColumnConstraints(600));
        Scene scene = new Scene(pane);
        stage.setTitle("plugin ObjectAld");
        stage.setScene(scene);
        stage.show();
        model.notifierObservateurs();
    }

    public static void main(String[] args) {
        launch();
    }
}