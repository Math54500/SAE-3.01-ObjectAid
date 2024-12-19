package org.example.sae301objectaid;

import java.io.File;
public class Tree {

    /**
     * Pretty print the directory tree and its file names.
     *
     * @param folder
     *            must be a folder.
     * @return
     */
    public static String creerArbre(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié ");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        creerArbre(folder, indent, sb);
        return sb.toString();
    }

    private static void creerArbre(File folder, int indent,
                                           StringBuilder sb) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Erreur : chemin mal spécifié");
        }
        sb.append(ajouterEspace(indent));
        sb.append("+--");
        sb.append(folder.getName());
        sb.append("/");
        sb.append("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                creerArbre(file, indent + 1, sb);
            } else {
                ecrireFichier(file, indent + 1, sb);
            }
        }

    }

    private static void ecrireFichier(File file, int indent, StringBuilder sb) {
        sb.append(ajouterEspace(indent));
        sb.append(">--");
        sb.append(file.getName());
        sb.append("\n");
    }

    private static String ajouterEspace(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}