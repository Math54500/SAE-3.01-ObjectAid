package org.example.sae301objectaid;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
public class Tree {

    public static TreeItem creerArbre(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié ");
        }
        TreeItem<Objet> tree = new TreeItem<>();
        creerArbre(folder, tree);
        return tree;
    }

    private static void creerArbre(File folder,TreeItem tree) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié");
        }

        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                Objet doss = new Objet(file.getName());
                TreeItem<Objet> ndoss = new TreeItem<>(doss);

                tree.getChildren().add(ndoss);
                creerArbre(file, tree);
            } else {
                ecrireFichier(file, tree);
            }
        }

    }

    private static void ecrireFichier(File file, TreeItem tree) {
        Objet fich = new Objet(file.getName());
        TreeItem<Objet> item = new TreeItem<>(fich);
        tree.getChildren().add(item);
    }



}