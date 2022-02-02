package com.group10.decide;

/** 
 * Main class for the program.
 */
public class LaunchInterceptorProgram {

    public static void main(String[] args) {
        // Create a new ParameterManager object with an input file path as argument
        //ParameterManager pm = new ParameterManager(args[1]);
        ParameterManager pm = new ParameterManager("test-inputs/test-10p-alltrue.txt");
        Decider d = new Decider(pm);
        boolean decision = d.decide();
        if (decision) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
