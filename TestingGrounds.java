package edu.vtc.guppitus;

/**
 * Created by Seth Lunn on 6/6/2017.
 */

public class TestingGrounds {

    @Censor(reviewer= "Name", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    private int testField;


    @Censor(reviewer= "Name112411111111232131211111111", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    public int notReviewedMethod(int testInt)
    {
        return testInt;
    }

    @Censor(reviewer= "1111111111111111Name", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    @Censor(reviewer= "Name", reviewDate = "Today",
            reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
            fixed = false, fixedChanges = "none")
    public int reviewedMethod(int testInt)
    {
        return testInt;
    }

    public class insideTestingGrounds{

        @Censor(reviewer= "Name", reviewDate = "Today",
                reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
                fixed = false, fixedChanges = "none")
        private int insideTestField;

        @Censor(reviewer= "Name112411111111232131211111111", reviewDate = "Today",
                reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
                fixed = false, fixedChanges = "none")
        public int notReviewedInsidemethod(int testInt){
            return testInt;
        }

        @Censor(reviewer= "Name", reviewDate = "Today",
                reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
                fixed = false, fixedChanges = "none")
        @Censor(reviewer= "Name112411111111232131211111111", reviewDate = "Today",
                reviewedProblems = {Problems.BOUNDRIES, Problems.ERROR},
                fixed = false, fixedChanges = "none")
        public int insideReviewedMethod(int testInt)
        {
            return testInt;
        }

    }
}
