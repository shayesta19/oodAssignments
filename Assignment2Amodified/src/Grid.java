import java.io.*;
import java.util.Random;

public class Grid {
    int size;
    double[][] grid;
    private int boundaryValue;
    private PrintWriter fileOutput;
    private InputStreamReader reader;


    public void setBoundaryValue(int boundaryValue) {
        this.boundaryValue = boundaryValue;
    }

    public Grid(int size) {
        this.size = size;
        try{
            fileOutput=new PrintWriter(new FileWriter("C:\\Users\\Shayesta\\Desktop\\RobotAssignment2AOutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return returns a 2D array of doubles
     * */
    public double[][] createGrid() {
        grid = new double[size][size];
        double divisor = 0.1;
        for (int i = 0; i < grid.length; i++) {
           if (i % boundaryValue == 0)
                grid[i][0] = (int) 1;
            for (int j = 0; j < grid[0].length; j++) {
                if (i % boundaryValue == 0) {
                        grid[i][j] = (int) 1;
                } else if(j%boundaryValue==0) {
                    grid[i][j]=(int)1;
                }else {
                    grid[i][j] = 5 / divisor;
                    divisor++;
                }
            }
        }
        return grid;
    }
/**
 * @param grid the matrix to be printed
 * */
    public void printGrid(double[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {

            if (i % boundaryValue == 0) {
                //System.out.print(String.format("%1$.2f",grid[i][0]));
               // System.out.println();
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (i % boundaryValue == 0) {
                    System.out.print(String.format("|"+"%1$.2f", grid[i][j]) + "|");
                    fileOutput.print(String.format("|"+"%1$.2f", grid[i][j]) + "|");
                } else if(j%boundaryValue==0){
                    System.out.print(String.format("|"+"%1$.2f", grid[i][j])+ "|");
                    fileOutput.print(String.format("|"+"%1$.2f", grid[i][j]) + "|");
                }else{
                    System.out.print(String.format(" "+"%1$.2f",grid[i][j])+" ");
                    fileOutput.print(String.format(" "+"%1$.2f",grid[i][j])+" ");
                }
            }
            System.out.println();
            fileOutput.println();
            fileOutput.close();
        }
    }
}

