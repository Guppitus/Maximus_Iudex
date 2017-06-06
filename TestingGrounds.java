package edu.vtc.guppitus;

/**
 * Created by Seth Lunn on 6/6/2017.
 */
public class TestingGrounds {

    @Censor(reviewer= "Name", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    private int testField;

    @Censor(reviewer= "Name", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    public int testMethod(int testInt)
    {
        return testInt;
    }
}
