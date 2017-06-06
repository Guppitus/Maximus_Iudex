package edu.vtc.guppitus;

import java.lang.annotation.*;

/**
 * Created by Seth Lunn on 6/6/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Repeatable(Censors.class)
public @interface Censor {
    String reviewer();
    String reviewDate();
    Problems[] reviewedProblems();
    boolean fixed();
    String fixedChanges();
}
