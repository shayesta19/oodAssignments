import java.util.*;

public class RobotScheduler {

    private ArrayList<RobotTask> taskList;
    private HashMap<Integer, ArrayList<RobotTask>> tasksMap;

    public RobotScheduler() {
        taskList = new ArrayList<>();
        tasksMap = new HashMap<>();
    }


    public void addRobotTask(RobotTask task,int robotID) {
        taskList.add(task);
        if (robotID==task.getAssignedRobot().getRobotID()) {
            ArrayList<RobotTask> list = tasksMap.get(task.getAssignedRobot().getRobotID());
            list.add(task);
        } else {
            tasksMap.put(robotID, taskList);
        }
    }

    public RobotTask getRobotTask(int robotID) {
        RobotTask robotTask;
        robotTask = taskList.get(robotID);
        return robotTask;
    }

    public List<RobotTask> getTasksList(Robot robotID) {
        if (tasksMap.get(robotID.getRobotID()) == null) {
            return null;
        } else
            return tasksMap.get(robotID.getRobotID());
    }

    public void deleteTask(int robotID) {
        taskList.remove(robotID);
        tasksMap.remove(taskList.get(robotID).getAssignedRobot().getRobotID());
    }

    public void displayRobotandRobotTasks() {
        int index = 1;
        for (Map.Entry<Integer, ArrayList<RobotTask>> robotID : tasksMap.entrySet()) {
            int key = robotID.getKey();
            ArrayList<RobotTask> value = robotID.getValue();
            System.out.println(index + " " + key);
            for (RobotTask robotTask : value) {
                System.out.println(robotTask);
            }
            index++;
        }
    }
}
//string format method for the classes.
//fix the hashcode and equals method