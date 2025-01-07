package org.example.sae301objectaid;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
public class Tree {

    public static TreeItem creerArbre(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié ");
        }
        TreeItem<String> tree = new TreeItem<>(folder.getName());
        creerArbre(folder, tree);
        return tree;
    }

    private static void creerArbre(File folder,TreeItem tree) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié");
        }

        for (File file : folder.listFiles()) {
            TreeItem<String> ndoss = new TreeItem<>(file.getName());
            tree.getChildren().add(ndoss);

            if (file.isDirectory()) {
                creerArbre(file, ndoss);
            }
        }

    }




}