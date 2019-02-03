package main;

/*
name :shayesta parveen reehan
NUID: 001401028
 */
import main.Bucket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Fluid_density {
    private static final String ENTER_BUCKET_DIMENSIONS = "Enter bucket dimensions";
    private static final String CALCULATE_CUBIC_VOLUME = "Calculate cubic volume";
    private static final String CALCULATE_CUBIC_WEIGHT = "Calculate cubic weight";
    private static final String PRINT_HISTORY = "Print history";
    private static final String EXIT = "Exit";

    private static Bucket bucket = new Bucket();
    private static Stack<Double> weights = new Stack<>();
    private static Stack<Double> volumes = new Stack<>();

    public static void main(String[] args) throws IOException {

        while (true) {
            menu();
            System.out.println("enter choice (1,2,3,4), or \'q\' to quit, then press <enter>:");
            run();
        }
    }

    public static void run() throws IOException {
        char input = getInput();
        do {
            switch (input) {
                case '1': { //request size height width length
                    System.out.println("You selected " + ENTER_BUCKET_DIMENSIONS);
                    userInput();
                    return;
                }
                case '2': {//calculate cubic volume
                    System.out.println("You selected " + CALCULATE_CUBIC_VOLUME);
                    double volume = volume(computeHeightOfWater());
                    volumes.push(volume);
                    System.out.println("volume = " + volume);
                    return;
                }
                case '3': { //calculate contents of the bucket using fluid density function
                    System.out.println("You selected " + CALCULATE_CUBIC_WEIGHT);
                    double weight = weight();//Iterate over the volume and sum the weight values
                    weights.push(weight);
                    System.out.println("weight = " + weight);
                    return;
                }
                case '4': {
                    System.out.println("You selected " + PRINT_HISTORY);
                    lastThree(weights, "Weight #");
                    lastThree(volumes, "Volume #");
                    return;
                }
                default:
                    System.out.println("you selected an invalid option" + input);
                    return;
                case 'q':
                    break;
            }
        }
        while (input != 'q');
        {
            System.out.println("Quitting...");
            System.exit(0);
        }
    }

    private static List<Double> lastThree(Stack<Double> elements, String prefix) {
        List<Double> lastThree = new ArrayList<>();
        int size = elements.size();
        if (size < 3) {
            for (int i = 0; i < size; i++) {
                lastThree.add(elements.pop());
            }
        } else {
            for (int i = 0; i < 3; i++) {
                lastThree.add(elements.pop());
            }
        }
        int index = 1;
        for (int i = lastThree.size() - 1; i >= 0; i--) {
            System.out.print(prefix + index++ + ": ");
            Double element = lastThree.get(i);
            System.out.println(element);
            elements.push(element);
        }
        return lastThree;
    }

    private static char getInput() throws IOException {
        char input;
        input = (char) System.in.read();
        while (input == '\n' || input == '\r') {
            input = (char) System.in.read();
        }
        return input;
    }

    private static void menu() {
        System.out.println();
        System.out.println("1. " + ENTER_BUCKET_DIMENSIONS);
        System.out.println("2. " + CALCULATE_CUBIC_VOLUME);
        System.out.println("3. " + CALCULATE_CUBIC_WEIGHT);
        System.out.println("4. " + PRINT_HISTORY);
        System.out.println("q. " + EXIT);
    }

    public static double weight() {
        double fractionDepth = computeHeightOfWater() % 1;
        double weight = density(fractionDepth) * volume(fractionDepth);
        int depth = (int) computeHeightOfWater();
        for (int i = 1; i <=depth; i++) {//going in one meter steps and summing the weight
            weight = weight + density(i + fractionDepth) * volume(1);
        }
        return weight;
    }

    private static double density(double depth) {
        return (1.0 + 0.03 * Math.pow(depth, 2));
    }

    private static double volume(double depth) {
        return depth * bucket.getLength() * bucket.getWidth();
    }

    private static double computeHeightOfWater() {
        return bucket.getDepth() == bucket.getHeight() ? bucket.getDepth() : bucket.getHeight() - bucket.getDepth();
    }

    private static void userInput() {
        Scanner inp = new Scanner(System.in);
        System.out.println("enter value for width");
        bucket.setWidth(inp.nextDouble());
        System.out.println("enter value for length");
        bucket.setLength(inp.nextDouble());
        System.out.println("enter value for height");
        bucket.setHeight(inp.nextDouble());
        System.out.println("enter value for depth (less than or equal to height)");
        double depthInput = inp.nextDouble();
        while (depthInput > bucket.getHeight()) {
            System.out.println("enter value for depth (less than or equal to height)");
            depthInput = inp.nextDouble();
        }
        bucket.setDepth(depthInput);
    }

}


