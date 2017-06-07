package edu.vtc.guppitus;
import com.sun.istack.internal.NotNull;

import java.lang.reflect.Method;


/**
 * Checks given class for annotated reviewed methods that have been marked with specified problems.
 * Created by Seth Lunn on 6/6/2017.
 */
public class MaximusIudex {

    /**
     * Checks class for reviewed methods or nested classes that have specified problems.
     * @param className The name of the class being checked
     * @param problems list of specified problems
     */

    public static void censorCheck ( @NotNull String className, @NotNull String[] problems )
    {
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

    /**
     * checks methods within a class for reviewed status.
     * @param reflectedClass the class containing methods to be checked for annotation
     * @param problems list of problems being checked for.
     */
    public static void checkMethods (@NotNull Class reflectedClass, @NotNull String[] problems)
    {
        Method[] classMethods = reflectedClass.getMethods();
        for (Method method : classMethods) {
            if (method.isAnnotationPresent(Censor.class)){
                checkProblems(method, problems);
            }
            if (method.isAnnotationPresent(Censors.class)) {
                checkProblemsRepeat(method, problems);
            }

        }
    }
    /**
     * checks the annotation for list of problems. If the method is marked with matching problems, a string is printed.
     * @param reviews the method being checked
     * @param problems problems being checked
     */
    public static void checkProblems (@NotNull Method reviews, @NotNull String[] problems)
    {
        Censor annot = reviews.getAnnotation(Censor.class);
            for(Problems problem: annot.reviewedProblems()){
                for(String name : problems) {
                    if (problem.toString().equalsIgnoreCase(name)) {
                        System.out.println(reviews.getName()+" has a " + problem.toString() + " problem.");
                    }
                }
            }
    }

    /**
     * checks the annotation for list of problems. If the method is marked with matching problems, a string is printed.
     * @param reviews the method being checked
     * @param problems problems being checked
     */
    public static void checkProblemsRepeat (@NotNull Method reviews, @NotNull String[] problems)
    {
        Censors annot = reviews.getAnnotation(Censors.class);
        for(Censor review : annot.value()){
            for(Problems problem: review.reviewedProblems()){
                for(String name : problems) {
                    if (problem.toString().equalsIgnoreCase(name)) {
                        System.out.println(reviews.getName()+" has a " + problem.toString() + " problem.");
                    }
                }
            }
        }
    }

    /**
     * Checks nested class for matching problems in review annotation
     * @param reflectedClass the parent class
     * @param problems the list of problems being checked for.
     */
    public static void checkNestedClasses (@NotNull Class reflectedClass, @NotNull String[] problems)
    {
        Class[] classClasses = reflectedClass.getDeclaredClasses();
        for (Class classy : classClasses) {
            checkMethods(classy, problems);
        }
    }
}



