package main;

import java.io.IOException;
import java.util.Scanner;

public class Fluid_density {
    public static void main(String[] args) {
        Bucket b = new Bucket();
        //getting the user inputs for height width length
        //printing out the three latest values of volume/height calculations
        // points 3 and 4
        //make the switch cases more reader friendly

        public void run () throws IOException {
            char input;
            System.out.println("enter choice (1,2,3,4), or \'q\' to quit, then press <enter>");
            do {
                input = (char) System.in.read();
                if (input == '\n') continue;
                if (input == '\r') continue;
                switch (input) {
                    case '1': //request size height width length
                        System.out.println("you selected option 1");
                        userInput();
                        break;
                    case '2': //calculate cubic volume
                        System.out.println("you selected option 2");
                        volume();
                        break;
                    case '3': //calculate contents of the bucket using fluid density function
                        System.out.println("you selected option 3");
                        density(); //Iterate over the volume and sum the weight values
                        break;
                    case '4':
                        System.out.println("you selected option 4");
                        for (int i = 0; i <= 3; i++) {
                            //Print a history of the last three  bucket calculations
                            //print volume/weight calculations
                        }
                        break;
                    default:
                        System.out.println("you selected an invalid option" + input);
                        break;
                    case 'q':
                        break;
                }
            }
            while (input != 'q');
            {
                System.out.println("Quitting...");
            }
        }
        public static double weight () {
            double weight = (1.0 + 0.03 * Math.pow(b.getHeight(), 2));
            return weight;
        }
        private static void density () {
            double density = volume() / weight();
        }

        private static double volume () {
            double volume = b.getHeight() * b.getLength() * b.getWidth();
            return volume;
        }

        private static void userInput () {
            Scanner inp = new Scanner(System.in);
            do {
                System.out.println("enter value for width");
                b.setWidth(inp.nextDouble());
                System.out.println("enter value for height");
                b.setHeight(inp.nextDouble());
                System.out.println("enter value for length");
                b.setLength(inp.nextDouble());
            } while (); {

            }


        }
    }
}

/*Assignment 1:  Due January 23rd, 6:00 pm*
Assignment 1:  Due January 23rd, 6:00 pm

• Write a java program that helps  model the weight of a square bucket of fluid:
• Each bucket has a width, length and a height measured in meters
• The fluid density varies with the height:
• Cubic Weight based on depth = (1.0 + 0.03 * (meter depth) 2 ) Kg
• For example, at 3 meters deep, the weight of a cubic meter would be:
• W(3m) = 1.0 + (0.03) * (3m) 2 = 1.27 Kg
• Use a loop to accept keyboard command input
• Use a switch statement to provide four input options (commands) :
1) Request the size (i.e. width, length and height) of the bucket measured in meters
2) Calculate the  cubic volume (m 3 ) of the bucket
3) Calculate the weight of the bucket contents using the fluid density function shown above  – Note: Do not use Calculus  – Iterate over the volume and sum the weight values
4) Print a history of the last three  bucket calculations and their volume/weight totals
5) Quit – Allow the user to exit from the program
• You may use the sample starter code (CSYE6200Assign1.java) which is attached to the Blackboard assignment page.
• Submit your source code to Blackboard. Please fill in your name and NUID number

package assign1;

/**
 * A starter file for implementing CSYE 6200 Assignment 1 <br>
 * Note: the package is 'assign1' so your code should be in your source folder under 'assign1'
 * [i.e. (your workspace path)\src\assign1\CSYE6200Assign1.java]
 *
 * Filename: CSYE6200Assign1.java <br>
 *
 * NUID: (your ID here) <br>
 * @author (your name here)

class CSYE6200Assign1 {


      Your program starts with this method call

    public static void main(String args[]) throws java.io.IOException {
        // Create an instance of the class, and call the constructor method
        CSYE6200Assign1 prog1 = new CSYE6200Assign1();

        prog1.run(); // call the run method - your program executes in this method

        // We're done. The program will exit.
    }

    //double sqrValue; // Uncomment to use with the method example shown below

    /**
     * Assign1 Constructor

    public CSYE6200Assign1() {
        // After a 'new' call the constructor is executed first - for now, nothing happens
        // If you had variables to create, or needed to initialize arrays, you should do
        //   those functions here.

        // Uncomment to show a variable initialization using a method call. Uncomment the variable definition above as well.
        //sqrValue = calcTheSquare(27.3); // Calculate the value of 27.3 * 27.3;
    }

    /**
     * Perform all of the user operations

    public void run() throws java.io.IOException {
        char inChar = ' ';


        System.out.println("Enter choice (1,2,3), or \'q\' to quit, then press <enter>.");
        do {
            inChar = (char) System.in.read();
            if (inChar == '\n') continue; // Skip a (newline) character
            if (inChar == '\r') continue; // Skip a (carriage return) character
            // react to input and take appropriate action

            switch (inChar) {
                case '1':
                    System.out.println("You selected option 1");
                    break;
                case '2':
                    System.out.println("You selected option 2");
                    break;
                case '3':
                    System.out.println("You selected option 3");
                    break;
                default:
                    System.out.println("Invalid selection: " + inChar);
                    break;
                case 'q':
                    break;
            }


        }
        while (inChar != 'q'); // Exit on quit
        System.out.println("Quiting...");
    }


    /**
     * An example of a method call
     * @param a real value that should be squared
     * @return a squared value (i.e. value^2)

    public double calcTheSquare(double value) {
        double sqr = value * value;

        return sqr;
    }
}/
 */
