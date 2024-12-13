package org.example.sae301objectaid;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Model {

    public static void genererSource(String nomClasse) throws ClassNotFoundException {
        Class<?> c = Class.forName(nomClasse);
        System.out.println(nomClasse);
        for(Field field : c.getDeclaredFields()){
            System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
        }
        for(Method method : c.getDeclaredMethods()){
            System.out.print(Modifier.toString(method.getModifiers())+" "+method.getReturnType()+" "+method.getName()+"( ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length > 0){
                for (int i = 0; i < parameterTypes.length; i++){
                    String[] type = parameterTypes[i].getTypeName().split("\\.");
                    System.out.print(type[1]+" ");
                }
            }
            System.out.print(")\n");

        }
    }
}