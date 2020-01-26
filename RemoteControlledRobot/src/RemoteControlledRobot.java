import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Stack;

/*
 * Name: Shayesta Parveen Reehan
 * NUID: 001401028
 * */

public class RemoteControlledRobot {
	static Scanner in = new Scanner(System.in);
	static int X;
	static int Y;
	static Stack<Integer> pathCost = new Stack<>();
	static Stack<String> path = new Stack<>();
	static Stack<Integer> pathCostTempX = new Stack<>();
	static Stack<Integer> pathCostTempY = new Stack<>();
	static int[] targetInput = new int[2];
	public static int[][] grid = { 
			{ 1, 3, 4, 6, 9, 7, 5, 2 }, 
			{ 3, 5, 8, 4, 1, 9, 7, 2 }, 
			{ 2, 5, 8, 9, 2, 1, 7, 6 },
			{ 5, 3, 2, 1, 7, 1, 8, 9 }, 
			{ 4, 9, 7, 6, 3, 2, 5, 1 }, 
			{ 9, 1, 5, 8, 1, 7, 3, 2 },
			{ 1, 5, 8, 4, 9, 3, 4, 2 }, 
			{ 8, 3, 4, 1, 5, 1, 9, 6 }, 
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
		System.out.println("enter a y value less than 8");
		targetInput[1] = in.nextInt();
		return targetInput;
	}

	public static void XTraversal() {
		int x = targetInput[0];
		int y = targetInput[1];
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (j <= y && i == 0) {
				j++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			}else break;
		}for(int i=0,j=y;i<grid.length&&j<grid[0].length;) {
			if (i <= x && j == y) {
				i++;
				pathCost.push(grid[j][i]);
				path.push("the coordinates are " + i + " " + j);
			} else
		break;
		}
		System.out.println("the path cost is " + costIncurred(pathCost));
		 System.out.println("the last three coordinates are ");
		 printHistory();
	}

	public static void YTraversal() {
		int x = targetInput[0];
		int y = targetInput[1];
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (i <= x && j == 0) {
				i++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			}else break;
		}
			for(int i=x,j=0;i<grid.length&&j<grid[0].length;) {
			if (j <= y && i == x) {
				j++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			} else
				break;
		}
		System.out.println("the path cost is "+costIncurred(pathCost));
		System.out.println("the last three coordinates are ");
		printHistory();
	}

	public static void diagonalPath() {
		int x = targetInput[0];
		int y = targetInput[1];
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (i <= x && j <= y) {
				i++;
				j++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			}
			if (i == x && j <= y) {
				j++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			} else if (i <= x && j == y) {
				i++;
				pathCost.push(grid[i][j]);
				path.push("the coordinates are " + i + " " + j);
			} else
				break;
		}
		System.out.println("the path cost is "+costIncurred(pathCost));
		System.out.print("the last three coordinates are " );
		printHistory();

	}

	private static void xTraversalCost() {
		int x = targetInput[0];
		int y = targetInput[1];
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (j <= y && i == 0) {
				j++;
//				int xdirection = grid[i][j];
//				System.out.println(xdirection + " ");
				pathCostTempX.push(grid[i][j]);
			}else
				break;
		}
		for(int i=0,j=y;i<grid.length&&j<grid[0].length;) {
			if (i <= x && j == y) {
				i++;
//				int ydirection = grid[j][i];
//				System.out.print(ydirection + " ");
				pathCostTempX.push(grid[j][i]);
			} else
				break;
		}
		System.out.println("the cost for this path option is: "+costIncurred(pathCostTempX));
		
	}

	private static void yTraversalCost() {
		int x = targetInput[0];
		int y = targetInput[1];
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (i <= x && j == 0) {
				i++;
//				int ydirection = grid[j][i];
//				System.out.print(ydirection + " ");
				pathCostTempY.push(grid[j][i]);
				// pathCost += grid[i][j];
			}else break;
		}
			for(int i=x,j=0;i<grid.length&&j<grid[0].length;) {
				if (j <= y && i == x) {
					j++;
//					int xdirection = grid[i][j];
//					System.out.println(xdirection + " ");
					// pathCost += grid[i][j];
					pathCostTempY.push(grid[i][j]);
			}else
				break;
		}
		System.out.println("the cost for this path option is: "+costIncurred(pathCostTempY));
		
	}

	private static void diagonalPathCost() {
		int x = targetInput[0];
		int y = targetInput[1];
		int pathCost = 0;
		for (int i = 0, j = 0; i < grid.length && j < grid[0].length;) {
			if (i <= x && j <= y) {
				i++;
				j++;
				int diagonal = grid[i][j];
				System.out.print(diagonal + " ");
				pathCost += grid[i][j];
			} else
				break;
		}
		System.out.println("the cost for this path option is: " + pathCost);
	}

	public static int costIncurred(Stack<Integer>pathCost) {
		int sum = 0;
		for (int i : pathCost) {
			sum += i;
		}
		return sum;
	}

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
			System.out.println(index++ + ": ");
			String paths = lastThree.get(i);
			System.out.println(paths);
			
		}
		
	}
}



/*
 * 
 * looping input move from one set of coordinates to another. add comments fix
 * printHistory fix cost incurred fix traversals
 * 
 */
