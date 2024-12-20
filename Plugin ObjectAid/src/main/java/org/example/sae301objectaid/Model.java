package org.example.sae301objectaid;

import javafx.scene.canvas.Canvas;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Model implements Sujet {
    private final List<Observateur> observateurs ;
    private Canvas canvas ;


    public Model() {
        this.observateurs = new ArrayList<Observateur>();
    }

    public void enregistrerObservateur(Observateur observateur) {
        this.observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        this.observateurs.remove(observateur);
    }

    public void notifierObservateurs() {
        for (Observateur observateur : this.observateurs) {
            observateur.actualiser();
        }
    }

    public TreeItem afficherFichiers(){
        File f = new File(".\\Plugin ObjectAid\\src");
        return Tree.creerArbre(f);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas cvs) {
        this.canvas = cvs ;
    }

//    public static void genererSource(String nomClasse) throws ClassNotFoundException {
//        Class<?> c = Class.forName(nomClasse);
//        System.out.println(nomClasse);
//        for(Field field : c.getDeclaredFields()){
//            System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
//        }
//        for(Method method : c.getDeclaredMethods()){
//            System.out.print(Modifier.toString(method.getModifiers())+" "+method.getReturnType()+" "+method.getName()+"( ");
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            if (parameterTypes.length > 0){
//                for (int i = 0; i < parameterTypes.length; i++){
//                    String[] type = parameterTypes[i].getTypeName().split("\\.");
//                    System.out.print(type[1]+" ");
//                }
//            }
//            System.out.print(")\n");
//
//        }
//    }
}