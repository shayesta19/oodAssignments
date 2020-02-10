import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Robot {

//    public final String TOTAL_MASS = "kg";
//    public final String DIRECTION = "degrees";
//    public final String BATTERY_CAPACITY = "mA-Hour";
//    public final String ENGINE_POWER_DRAW = "mA";
//    public final String SPEED = "meters/second";//robot speed set in meters/second
    private int xdegrees;
    private int ydegrees;
    private String name;
    private String manufacturer;
    private int speed;
    private double weight;
    private int timeTakenToReach12Volts;//in seconds
    private int XPosition;
    private int YPosition;
    private double voltage;
    private double current;
    private double enginePowerDraw;
    private double batteryCapacity;
    private int efficiency; // set own efficiency values eg.82% etc.
    private Queue<String> boundaryTransition = new LinkedList<>();
    public PrintWriter fileOutput;
    private int RobotID;

    public int getRobotID() {
        return RobotID;
    }

    public void setRobotID(int robotID) {
        RobotID = robotID;
    }

    public Robot(String name, int robotID,String manufacturer, double weight, double voltage, double current, int efficiency,
                 int timeTakenToReach12Volts, double batteryCapacity, int speed, int XPosition, int YPosition) {
        try {
            fileOutput=new PrintWriter(new FileWriter("C:\\Users\\Shayesta\\Desktop\\RobotAssignment2AOutput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.manufacturer = manufacturer;
        this.voltage = voltage;
        this.current = current;
        this.efficiency = efficiency;
        this.timeTakenToReach12Volts = timeTakenToReach12Volts;
        this.weight = weight;
        this.XPosition = XPosition;
        this.YPosition = YPosition;
        this.speed = speed;
        this.RobotID=robotID;
        this.batteryCapacity = batteryCapacity;
    }

    public double getEnginePowerDraw() {
        return enginePowerDraw;
    }

    public void setEnginePowerDraw(double enginePowerDraw) {
        this.enginePowerDraw = enginePowerDraw;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getXPositon() {
        return XPosition;
    }

    public void setXPositon(int xPositon) {
        XPosition = xPositon;
    }

    public int getYPosition() {
        return YPosition;
    }

    public int getXdegrees() {
        return xdegrees;
    }

    public void setXdegrees(int xdegrees) {
        this.xdegrees = xdegrees;
    }

    public int getYdegrees() {
        return ydegrees;
    }

    public void setYdegrees(int ydegrees) {
        this.ydegrees = ydegrees;
    }

    public void setYPosition(int yPosition) {
        YPosition = yPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return getRobotID() == robot.getRobotID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRobotID());
    }

    /**
     * @param grid       the grid to be traversed
     * @param x          the x position to be reached
     * @param y          the y position to be reached
     * @param pathOption determines which method to be called to traverse the matrix
     *                   moves the robot to the x,y location in the array according to the pathOption parameter specified.
     */
    public void moveTo(double[][] grid, int x, int y, String pathOption) {
        double[][] grid1 = grid;
        if (pathOption.equalsIgnoreCase("Xtraversal")) {
            XTraversal(grid, x, y);

        } else if (pathOption.equalsIgnoreCase("YTraversal")) {
            YTraversal(grid, x, y);

        } else if (pathOption.equalsIgnoreCase("diagonal")) {
            diagonal(grid, x, y);
        }
    }

    /**
     * @param grid the grid to be traversed
     * @param x    the x position to be reached
     * @param y    the y position to be reached
     *             this method increments both x and y values simultaneously initially and then increments either the x position
     *             or the y position until the x,y position is reached in the array
     *             additionally calculates battery capacity, engine power draw, and sets those values.
     */
    private void diagonal(double[][] grid, int x, int y) {
        double[][] grid1 = grid;
        int i = 0, j = 0;
        for (i = 0, j = 0; i < grid.length && j < grid[0].length; ) {
            if (i <= x && j <= y) {
                if (grid[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setXdegrees(45);
                setYdegrees(45);
                i++;
                j++;
            } else break;
        }
        for (int row = i - 1, col = j - 1; row < grid1.length && col < grid1[0].length; ) {
            if (row == x && col < y) {
                if (grid[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setXdegrees(180);
                col++;
            } else if (row < x && col == y) {
                if (grid[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setYdegrees(90);
                row++;

            } else break;
        }
        setBatteryCapacity(calculateBatteryCapacity());
        setEnginePowerDraw(calculateEnginePowerDraw());
    }

    /**
     * @param grid the grid to be traversed
     * @param x    the x position to be reached
     * @param y    the y position to be reached
     *             this method first increments the row values up to the point x and then starts incrementing the column values up to y
     *             until the x,y position is reached in the array.
     *             additionally calculates battery capacity, engine power draw, and sets those values.
     */
    private void YTraversal(double[][] grid, int x, int y) {
        double[][] grid1 = grid;
        for (int i = 0, j = 0; i < grid1.length && j < grid1[0].length; ) {
            if (i < x && j == 0) {
                if (grid1[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setYdegrees(90);
                i++;
            } else break;
        }
        for (int i = x, j = 1; i < grid1.length && j < grid1[0].length; ) {
            if (j <= y && i == x) {
                if (grid[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setXdegrees(180);
                j++;
            } else break;
        }
        setBatteryCapacity(calculateBatteryCapacity());
        setEnginePowerDraw(calculateEnginePowerDraw());
    }

    /**
     * @param grid the grid to be traversed
     * @param x    the x position to be reached
     * @param y    the y position to be reached
     *             this method first increments the column values up to the point y and then starts incrementing the row values up to x
     *             until the x,y position is reached in the array.
     *             additionally calculates battery capacity, engine power draw, and sets those values.
     */
    private void XTraversal(double[][] grid, int x, int y) {
        double[][] grid1 = grid;
        for (int i = 0, j = 0; i < grid1.length && j < grid1[0].length; ) {
            if (j < y && i == 0) {
                if (grid1[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setXdegrees(180);
                j++;
            } else break;
        }
        for (int i = 1, j = y; i < grid1.length && j < grid[0].length; ) {
            if (i <= x) {
                if (grid1[i][j] == (int) 1) {
                    boundaryTransition.add(i + " " + j);
                }
                setYdegrees(90);
                i++;

            } else break;
        }
        setBatteryCapacity(calculateBatteryCapacity());
        setEnginePowerDraw(calculateEnginePowerDraw());
    }

    /**
     * calculates the engine power draw of the robot as a product of the voltage, efficiency,current
     */
    public double calculateEnginePowerDraw() {
        return (this.voltage * this.efficiency * this.current) / 746;
    }

    /**
     * calculates the battery capacity of the robot as a product of the current
     * field and the time it takes for the robot to reach 12 volts
     */
    public double calculateBatteryCapacity() {
        return this.current * this.timeTakenToReach12Volts * 2;
    }

    /**
     * @return returns a formatted string of the major fields of the robot class
     */
    public String toFormattedString() {
        return String.format("Name : %1$5s || ID: %2$d || Manufacturer:  %3$5s || Weight: %4$.2f kgs || XPosition: %5$1d moving at %6$2d degrees || YPosition: %7$1d moving at %8$2d degrees || speed: %9$2d meters/second || Engine Power Draw: %10$.2f mA || Battery Capacity: %11$.2f mA-Hour ", getName(), getRobotID(),getManufacturer(), getWeight(), getXPositon(), getXdegrees(), getYPosition(), getYdegrees(), getSpeed(), getEnginePowerDraw(), getBatteryCapacity());
    }

    public void printBoundaryTransitions() {
        for (String s : boundaryTransition) {
            System.out.println("the boundary transition happened at this point: " + s + "   ");
            fileOutput.println("the boundary transition happened at this point: " + s + "   ");
        }
        System.out.println();
        fileOutput.println();
        fileOutput.close();
    }
}
