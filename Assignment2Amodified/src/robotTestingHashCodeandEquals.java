import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class robotTestingHashCodeandEquals {
    public static void main(String[] args) {
        RobotScheduler robotScheduler = new RobotScheduler();
        String datetime = "11-12-2020 10:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(datetime, formatter);
        Robot robot1 = new Robot("robot 1", 1234, "NVIDIA", 2.0, 51.8, 1.2, 82, 10, 50.0, 5, 10, 8);
        Robot robot2 = new Robot("robot 2", 4567, "Intel", 2.5, 49.0, 1.5, 90, 5, 80, 10, 9, 9);

        RobotTask task1 = new RobotTask(1, "task1", "11-12-2020", "10:30:10", robot1, "performs TASK1");
        RobotTask task2 = new RobotTask(2, "task2", "11-12-2020", "10:30:10", robot1, "performs TASK2");
        RobotTask task3 = new RobotTask(3, "task3", "11-12-2020", "10:30:10", robot1, "performs TASK3");

        RobotTask task4 = new RobotTask(4, "task4", "11-12-2020", "10:30:10", robot2, "performs TASK4");
        RobotTask task5 = new RobotTask(5, "task5", "11-12-2020", "10:30:10", robot2, "performs TASK5");
        RobotTask task6 = new RobotTask(6, "task6", "11-12-2020", "10:30:10", robot2, "performs TASK6");

        robotScheduler.addRobotTask(1234, task1);
        robotScheduler.addRobotTask(1234, task2);
        robotScheduler.addRobotTask(1234, task3);

        robotScheduler.addRobotTask(4567, task4);
        robotScheduler.addRobotTask(4567, task5);
        robotScheduler.addRobotTask(4567, task6);
        robotScheduler.displayRobotandRobotTasks();
        System.out.println("////////////////////prints out the task list");
        robotScheduler.displayListContents(robotScheduler.getTaskList());

        System.out.println("///////deletes task 5 ");
        robotScheduler.deleteTask(4567, task5);
        System.out.println("////////displays robot tasks");
        robotScheduler.displayRobotandRobotTasks();
        RobotTask task=robotScheduler.getRobotTaskFromList(4567);
        System.out.println("/////////testing out getting robot from list");
        System.out.println(task);
        ArrayList<RobotTask> list = robotScheduler.getRobotTaskFromMap(1234);
        System.out.println("/////testing out getting arraylist from map ");
        robotScheduler.displayListContents(list);
    }
}
