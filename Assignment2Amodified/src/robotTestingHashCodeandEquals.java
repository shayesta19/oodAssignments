import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class robotTestingHashCodeandEquals {
    public static void main(String[] args) {
        RobotScheduler robotScheduler = new RobotScheduler();
        String datetime = "11-12-2020 10:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(datetime, formatter);
        Robot robot1=new Robot("robot 1",1234,"NVIDIA",2.0,51.8,1.2,82,10,50.0,5,10,8);
        Robot robot2=new Robot("robot 2",4567,"Intel",2.5,49.0,1.5,90,5,80,10,9,9);


        RobotTask rt1 = new RobotTask(123, "run", formatDateTime, robot1, "to move to a location");
        RobotTask rt2 = new RobotTask(123, "move", formatDateTime, robot1, "move to a different location");
        RobotTask rt3 = new RobotTask(321, "talk", formatDateTime, robot2, "talks");
        RobotTask rt4 = new RobotTask(321, "move", formatDateTime, robot1, "moves to a location");

        robotScheduler.addRobotTask(rt1);
        robotScheduler.addRobotTask(rt2);
        robotScheduler.addRobotTask(rt3);
        robotScheduler.addRobotTask(rt4);

        robotScheduler.displayRobotandRobotTasks();
    }
}
