package edu.vtc.guppitus;

import static edu.vtc.guppitus.ConsoleCommand.consoleClass;
import static edu.vtc.guppitus.ConsoleCommand.consoleProblemList;

public class Main {

    public static void main(String[] args) {
        String classTestName = consoleClass();
        String[] problem = consoleProblemList();
        MaximusIudex.censorCheck(classTestName, problem);
    }
}
