package edu.vtc.guppitus;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * Created by Seth Lunn on 6/6/2017.
 */
public class MaximusIudex {


    public static void censorCheck ( String className, String[] problems ) {

        try {
            //TODO improve pkg handling
            Class reflectClass = Class.forName("edu.vtc.guppitus." + className);
            System.out.println("Class " + reflectClass.getName() + "found.");


            //If class has not been reviewed, then check for reviewed methods and nested classes
            if (!reflectClass.isAnnotationPresent(Censor.class)) {

                checkMethods(reflectClass, problems);
                checkNestedClasses(reflectClass, problems);

            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }

    }

    public static void checkMethods (Class reflectedClass, String[] problems)
    {
        Method[] classMethods = reflectedClass.getMethods();

        for (Method method : classMethods) {
            if (method.isAnnotationPresent(Censors.class)) {

                Censors annot = method.getAnnotation(Censors.class);

                checkProblems(annot, problems);

            }
        }
    }

    public static void checkProblems (Censors review, String[] problems)
    {
        for(String problem : problems){

            System.out.println(review);


        }

    }

    public static void checkNestedClasses (Class reflectedClass, String[] problems)
    {
        Class[] classClasses = reflectedClass.getDeclaredClasses();

        for (Class classy : classClasses) {

            checkMethods(classy, problems);
        }
    }


}



