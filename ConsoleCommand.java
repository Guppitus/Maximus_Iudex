package edu.vtc.guppitus;

import java.util.Scanner;

/**
 * Created by Seth Lunn on 6/7/2017.
 */
public class ConsoleCommand {

    public static String consoleClass()
    {
        System.out.println("Enter class name in this package: ");
        Scanner s = new Scanner(System.in);
        String input = (s.nextLine());
        return input;

    }

    public static String[] consoleProblemList()
    {
        System.out.println("Enter problems to check for: \" problem1 problem2 problem3 \" ");
        Scanner s = new Scanner(System.in);
        String input = (s.nextLine());
        String[] inputArray = input.split(" ");
        for(String problems: inputArray)
        {
            problems.replaceAll("\\s+","");
        }
        return inputArray;
    }

}
