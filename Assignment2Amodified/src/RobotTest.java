import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RobotTest {
	static PrintWriter fileOutput;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			fileOutput=new PrintWriter(new FileWriter("C:\\Users\\shayesta\\Desktop\\RobotAssignment2AOutput.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("enter an even number greater than 2 for grid size");
		fileOutput.println("enter an even number greater than 2 for grid size");
		int size = in.nextInt();
		Grid g = new Grid(size);
		fileOutput.print(g);
		System.out.println("enter a boundary value");
		fileOutput.println("enter a boundary value");
		int boundaryValue = in.nextInt();
		g.setBoundaryValue(boundaryValue);
		double[][] grid = g.createGrid();
//		for(int i=0;i<grid.length;i++){
//			double[] row=grid[i];
//			for(double cel:row){
//				System.out.print(String.format("%1.2f",cel)+" ");
//				if(i%boundaryValue==0){
//					System.out.println();
//					continue;
//				}
//			}
//			System.out.println();
//		}
		System.out.println();
		fileOutput.println();
		g.printGrid(grid);
		Robot robot1=new Robot("robot 1","NVIDIA",2.0,51.8,1.2,82,10,50.0,5,10,8);
		Robot robot2=new Robot("robot 2","Intel",2.5,49.0,1.5,90,5,80,10,9,9);
		Robot robot3=new Robot("robot 3","AMD",3.0,40.0,1.3,95,7,92,11,5,4);
		Robot robot4=new Robot("robot 4","fuji",3.2,49.0,1.4,85,5,60,20,3,2);
		Robot robot5=new Robot("robot 5","mitsubishi",3.0,50.0,1.7,92,5,90,15,7,7);


		//////robot 1///////////
		robot1.moveTo(grid,10,8,"Xtraversal");
		System.out.println(robot1.toFormattedString());
		fileOutput.println(robot1.toFormattedString());
		robot1.printBoundaryTransitions();

		//////robot 2///////////
		robot2.moveTo(grid,9,9,"Ytraversal");
		System.out.println(robot2.toFormattedString());
		fileOutput.println(robot2.toFormattedString());
		robot2.printBoundaryTransitions();

		//////robot 3///////////
		robot3.moveTo(grid,5,4,"diagonal");
		System.out.println(robot3.toFormattedString());
		fileOutput.println(robot3.toFormattedString());
		robot3.printBoundaryTransitions();

		//////robot 4///////////
		robot4.moveTo(grid,3,2,"Ytraversal");
		System.out.println(robot4.toFormattedString());
		fileOutput.println(robot4.toFormattedString());
		robot4.printBoundaryTransitions();

		//////robot 5///////////
		robot5.moveTo(grid,7,7,"diagonal");
		System.out.println(robot5.toFormattedString());
		fileOutput.println(robot5.toFormattedString());
		robot5.printBoundaryTransitions();

		fileOutput.close();
	}
}
