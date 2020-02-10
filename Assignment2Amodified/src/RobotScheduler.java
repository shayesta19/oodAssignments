import java.util.*;

public class RobotScheduler {

    private ArrayList<RobotTask> taskList;
    private HashMap<Integer, ArrayList<RobotTask>> tasksMap;

    public RobotScheduler() {
        taskList = new ArrayList<>();
        tasksMap = new HashMap<>();
    }

    private boolean sameKeys(int ID){
        return tasksMap.containsKey(ID);
    }
    public void addRobotTask(int robotID,RobotTask task) {
        taskList.add(task);
        if (sameKeys(robotID)) {
            ArrayList<RobotTask> list = tasksMap.get(task.getAssignedRobot().getRobotID());
            list.add(task);
        } else {
            tasksMap.put(task.getAssignedRobot().getRobotID(), new ArrayList<RobotTask>());
            ArrayList<RobotTask>list1=tasksMap.get(task.getAssignedRobot().getRobotID());
            list1.add(task);
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

    public void displayListContents(){
        int index=1;
        for(RobotTask rt:taskList){
            System.out.println(index+" "+rt);
            index++;
        }
    }
    public void displayRobotandRobotTasks() {
        int index = 1;
        for (Map.Entry<Integer, ArrayList<RobotTask>> robotID : tasksMap.entrySet()) {
            int key = robotID.getKey();
            ArrayList<RobotTask> value = robotID.getValue();
            System.out.println(index + " " + key);
            for (RobotTask robotTask : value) {
                System.out.println(robotTask);
               // robotTask.formattedString();
            }
            index++;
        }
    }
}
//string format method for the classes.
//test out all methods
//good commenting
//learn git branching and other stuff and a lot of stuff in java hashcode equals practice
/*
 * test out remove method
 *variables should be named well
 */