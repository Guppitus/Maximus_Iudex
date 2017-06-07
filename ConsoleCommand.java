package edu.vtc.guppitus;

import java.util.Scanner;

/**
 * Created by Seth Lunn on 6/7/2017.
 */

class ConsoleCommand {

    static String consoleClass()
    {
        System.out.println("Enter class name in this package: ");
        Scanner s = new Scanner(System.in);
        return (s.nextLine());

    }

    static String[] consoleProblemList()
    {
        System.out.println("Enter problems to check for: \" problem1 problem2 problem3 \" ");
        Scanner s = new Scanner(System.in);
        String input = (s.nextLine());
        return input.split(" ");
    }

}
