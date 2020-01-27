import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/*
 * Name: Shayesta Parveen Reehan
 * NUID: 001401028
 * */

public class RemoteControlledRobot {
    static Scanner in = new Scanner(System.in);
    static int X;
    static int Y;
    static int tempX;
    static int tempY;
    static Queue<Integer> pathCost = new LinkedList<>();
    static Stack<String> path = new Stack<>();
    static Queue<Integer> pathCostTempX = new LinkedList<>();
    static Queue<Integer> pathCostTempY = new LinkedList<>();
    static Queue<Integer> pathCostTempDiagonal = new LinkedList<>();
    static LinkedList<Integer> inputHistory=new LinkedList<>();
    static int[] targetInput = new int[2];

    public static int[][] grid = {
            {1, 3, 4, 6, 9, 7, 5, 2},
            {3, 5, 8, 4, 1, 9, 7, 2},
            {2, 5, 7, 9, 2, 1, 7, 6},
            {5, 3, 2, 1, 7, 1, 8, 9},
            {4, 9, 7, 6, 3, 2, 5, 1},
            {9, 1, 5, 8, 1, 7, 3, 2},
            {1, 5, 8, 4, 9, 3, 4, 2},
            {8, 3, 4, 1, 5, 1, 9, 6},
    };

    public static void main(String[] args) throws IOException {
        printGrid();
        while (true) {
            char input;
            do {
                printMenu();
                System.out.println("enter choice 1,2,3,4, or \'q\' to quit, then press enter:");
                input = getInput();
                switch (input) {
                    case '1': {
                        System.out.println("enter target input");
                        targetInput();
                        inputHistory.add(targetInput[0]);
                        inputHistory.add(targetInput[1]);
                        break;
                    }
                    case '2': {
                        System.out.println("print path options and drive to location");
                        printPathOptions();
                        System.out.println("select a path option 1.XTraversal 2.YTraversal 3.Diagonal");
                        int pathOption = in.nextInt();
                        driveToLocation(pathOption);
                        break;
                    }
                    case '3': {
                        System.out.println("cost incurred ");
                        System.out.println(costIncurred(pathCost));
                        break;
                    }
                    case '4': {
                        System.out.println("print history");
                        printHistory();
                        break;
                    }
                    default:
                        System.out.println("you selected an invalid option" + input);
                    case 'q': {
                        break;
                    }

                }
            } while (input != 'q');
            {
                System.out.println("quitting");
                System.exit(0);
            }

        }

    }

    private static char getInput() throws IOException {
        char input;
        input = (char) System.in.read();
        while (input == '\n' || input == '\r') {
            input = (char) System.in.read();
        }
        return input;
    }

    public static void printGrid() {
        for (int row = 0; row < grid.length; row++) {
            int rowValues[] = grid[row];
            for (int cel : rowValues) {
                System.out.print(cel + " ");
            }
            System.out.println("");
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. enter target input");
        System.out.println("2. print path options and drive to location");
        System.out.println("3. cost incurred");
        System.out.println("4. print history");
        System.out.println("q. quit");
    }

    public static void printPathOptions() {
        System.out.print("1. XTraversal ");
        xTraversalCost();
        System.out.print("2. YTraversal ");
        yTraversalCost();
        System.out.print("3. diagonalPath ");
        diagonalPathCost();
    }

    public static void driveToLocation(int i) {
        int pathoption = i;
        if (pathoption == 1) {
            XTraversal();
        } else if (pathoption == 2) {
            YTraversal();
        } else if (pathoption == 3) {
            diagonalPath();
        }
    }

    public static int[] targetInput() {
        System.out.println("enter an x value less than 8");
        targetInput[0] = in.nextInt();
        X=targetInput[0];
        System.out.println("enter a y value less than 8");
        targetInput[1] = in.nextInt();
        Y=targetInput[1];
        return targetInput;
    }
    /**
     * increments column values first keeping row values constant until the (0,y)index is reached
     * then increments the row values keeping column values constant until the (x,y) index is reached
     **/
    public static void XTraversal() {
        tempY = inputHistory.getLast();
        tempX = inputHistory.getLast();
        int loopy=inputHistory.getFirst();
        int loopx=inputHistory.getFirst();
        if (X == targetInput[0] && Y == targetInput[1]&&(tempY!=loopy&&tempX!=loopx)) {
            for (int i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
                if (j <= Y && i == 0) {
                    pathCost.add(grid[i][j]);
                    path.push("the coordinates are " + i + " " + j);
                    j++;
                } else break;
            }
            for (int i = 1, j = Y; i < grid.length && j < grid[0].length; ) {
                if (i <= X && j == Y) {
                    pathCost.add(grid[i][j]);
                    path.push("the coordinates are " + i + " " + j);
                    i++;
                } else
                    break;
            }
        }
       else if (tempX < targetInput[0] && tempY < targetInput[1]) {
            pathCost.clear();
            for (int i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
                if (j <= Y && i == 0) {
                    pathCost.add(grid[i][j]);
                    path.push("the coordinates are " + i + " " + j);
                    j++;
                } else break;
            }
            for (int i = 1, j = Y; i < grid.length && j < grid[0].length; ) {
                if (i <= X && j == Y) {
                    pathCost.add(grid[i][j]);
                    path.push("the coordinates are " + i + " " + j);
                    i++;
                } else break;
            }
        }else if(tempX==targetInput[0]&&tempY==targetInput[1]){
                xTraversalLoop(tempX,tempY);
            }

        }
    /**
     * increments row values first keeping column values constant until the (x,0)index is reached
     * then increments the column values keeping row values constant until the (x,y) index is reached
     **/

    public static void YTraversal() {
            tempX=inputHistory.getLast();
            tempY=inputHistory.getLast();
        if(tempX<targetInput[0]&&tempY<targetInput[1]){
            pathCost.clear();
        }else {
            yTraversalLoop(X,Y);
        }
        for (int i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j == 0) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                i++;

            } else break;
        }
        for (int i = X, j = 1; i < grid.length && j < grid[0].length; ) {
            if (j <= Y && i == X) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                j++;
            } else
                break;
        }
    }

    /**
     * increments both row and column indices until both are equal and then checks if either one of them is less than the
     * target value then increments that corresponding row/column index until (x,y) index is reached
     **/
    public static void diagonalPath() {
            tempX=inputHistory.getLast();
            tempY=inputHistory.getLast();
        if(tempX<targetInput[0]&&tempY<targetInput[1]){
            pathCost.clear();
        }else {
            diagonalTraversalLoop(X,Y);
        }
        int i = 0, j = 0;
        for (i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j <= Y) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                i++;
                j++;
            } else break;
        }
        for (int row = i - 1, col = j - 1; row < grid.length && col < grid[0].length; ) {

            if (row == X && col < Y) {
                col++;
                pathCost.add(grid[row][col]);
                path.push("the coordinates are " + row + " " + col);
            } else if (row < X && col == Y) {
                row++;
                pathCost.add(grid[row][col]);
                path.push("the coordinates are " + row + " " + col);
            } else
                break;
        }
    }

    private static void xTraversalLoop(int tempx,int tempy){
        for (int i = tempx, j = tempy; i < grid.length && j < grid[0].length; ) {
            if (j <= Y && i == tempx) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                j++;
            } else break;
        }
        for (int i = tempx+1 , j = tempy; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j == Y) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                i++;
            } else
                break;
        }

    }
    private static void yTraversalLoop(int tempx,int tempy){
        for (int i = tempx, j = tempy; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j == 0) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                i++;

            } else break;
        }
        for (int i = tempx, j = 1; i < grid.length && j < grid[0].length; ) {
            if (j <= Y && i == X) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                j++;
            } else
                break;
        }

    }
    private static void diagonalTraversalLoop(int tempx,int tempy){
        int i = tempx, j = tempy;
        for (i = tempx, j = tempy; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j <= Y) {
                pathCost.add(grid[i][j]);
                path.push("the coordinates are " + i + " " + j);
                i++;
                j++;
            } else break;
        }
        for (int row = i - 1, col = j - 1; row < grid.length && col < grid[0].length; ) {

            if (row == X && col < Y) {
                col++;
                pathCost.add(grid[row][col]);
                path.push("the coordinates are " + row + " " + col);
            } else if (row < X && col == Y) {
                row++;
                pathCost.add(grid[row][col]);
                path.push("the coordinates are " + row + " " + col);
            } else
                break;
        }

    }
    /**
     * helper function that calculates the cost of choosing XTraversal path option
     **/
    private static void xTraversalCost() {
        for (int i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (j <= Y && i == 0) {
                pathCostTempX.add(grid[i][j]);
                j++;
            } else break;
        }
        for (int i = 1, j = Y; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j == Y) {
                pathCostTempX.add(grid[i][j]);
                i++;
            } else
                break;
        }
        System.out.println("the cost for this path option is: " + costIncurred(pathCostTempX));

    }

    /**
     * helper function that calculates the cost of choosing YTraversal path option
     **/
    private static void yTraversalCost() {
        for (int i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j == 0) {
                pathCostTempY.add(grid[i][j]);
                i++;

            } else break;
        }
        for (int i = X, j = 1; i < grid.length && j < grid[0].length; ) {
            if (j <= Y && i == X) {
                pathCostTempY.add(grid[i][j]);
                j++;
            } else
                break;
        }
        System.out.println("the cost for this path option is: " + costIncurred(pathCostTempY));

    }

    /**
     * helper function that calculates the cost of choosing diagonal Traversal path option
     **/
    private static void diagonalPathCost() {
        pathCostTempDiagonal.clear();
        int i = 0, j = 0;
        for (i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (i <= X && j <= Y) {
                pathCostTempDiagonal.add(grid[i][j]);
                i++;
                j++;
            } else break;
        }
        for (int row = i - 1, col = j - 1; row < grid.length && col < grid[0].length; ) {

            if (row == X && col < Y) {
                col++;
                pathCostTempDiagonal.add(grid[row][col]);
            } else if (row < X && col == Y) {
                row++;
                pathCostTempDiagonal.add(grid[row][col]);
            } else
                break;
        }
        System.out.println("the cost for this path option is: " + costIncurred(pathCostTempDiagonal));
    }

    public static int costIncurred(Queue<Integer> pathCost) {
        int sum = 0;
        for (int i : pathCost) {
            sum += i;
        }
        return sum;
    }

    /**
     * prints the history of the last three indices traversed by popping the
     * top three elements stored in the stack.
     **/
    public static void printHistory() {
        List<String> lastThree = new ArrayList<>();
        int size = path.size();
        if (size < 3) {
            for (int i = 0; i < size; i++) {
                lastThree.add(path.pop());
            }
        } else {
            for (int i = 0; i < 3; i++) {
                lastThree.add(path.pop());
            }
        }
        int index = 1;
        for (int i = lastThree.size() - 1; i >= 0; i--) {
            System.out.print(index++ + ": ");
            String paths = lastThree.get(i);
            System.out.println(paths);

        }

    }
}
/*
Assignment 1:  Due January 27th, 6:00 pm

• Write a java program that helps  model a remote controlled robot:
• The robot moves in an 8 by 8 meter  grid
• Each grid cell has a ‘cost’ to traverse, which ranges from 1 (low) to 9 (high)
• The robot  is charged whenever it enters a new cell
• Use a loop to accept keyboard command input
• Use a switch statement to provide  for  input options (commands) :
1) Allow input of a target cell X,Y location
2) Determine path options, and calculate the cost incurred along the way (print options for the user)
3) Drive to the new location by selecting a path option
4) Print a history of the last three trips taken, and the cost of each
5) Quit – Allow the user to exit from the program
• Please comment your code, and think about making your code simple and easy to  write
• Submit your source code to Blackboard. Please fill in your name and NUID  number.
* */

