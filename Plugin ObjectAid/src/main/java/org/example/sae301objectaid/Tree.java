package org.example.sae301objectaid;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
public class Tree {

    public static TreeItem creerArbre(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié ");
        }
        Objet nf = new Objet(folder.getName());
        TreeItem<Objet> tree = new TreeItem<>(nf);
        creerArbre(folder, tree);
        return tree;
    }

    private static void creerArbre(File folder,TreeItem tree) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié");
        }

        for (File file : folder.listFiles()) {

            Objet doss = new Objet(file.getName());
            TreeItem<Objet> ndoss = new TreeItem<>(doss);
            tree.getChildren().add(ndoss);

            if (file.isDirectory()) {
                creerArbre(file, ndoss);
            } else {
                ecrireFichier(file, ndoss);
            }
        }

    }

    private static void ecrireFichier(File file, TreeItem tree) {
        Objet fich = new Objet(file.getName());
        TreeItem<Objet> item = new TreeItem<>(fich);
        tree.getChildren().add(item);
    }



}