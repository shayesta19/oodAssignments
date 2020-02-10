import java.util.*;

public class RobotScheduler {

    private ArrayList<RobotTask> taskList;
    private HashMap<Integer, ArrayList<RobotTask>> tasksMap;

    public RobotScheduler() {
        taskList = new ArrayList<>();
        tasksMap = new HashMap<>();
    }

    public ArrayList<RobotTask> getTaskList() {
        return taskList;
    }

    /**
     * helper method that checks if the key already exists in the tasksMap Hash Map
     *
     * @param ID the key value to the Hash Map
     */
    private boolean sameKeys(int ID) {
        return tasksMap.containsKey(ID);
    }

    /**
     * adds a robot task to both the array list and Hash Map by creating an entry in the Hash Map with robot id as key and Array List
     * as value
     *
     * @param robotID the ID that is stored as the key in the Hash Map
     * @param task    the task that needs to be added to both the Array List and Hash Map
     */
    public void addRobotTask(int robotID, RobotTask task) {
        taskList.add(task);
        if (sameKeys(robotID)) {
            ArrayList<RobotTask> list = tasksMap.get(task.getAssignedRobot().getRobotID());
            list.add(task);
        } else {
            tasksMap.put(task.getAssignedRobot().getRobotID(), new ArrayList<RobotTask>());
            ArrayList<RobotTask> list1 = tasksMap.get(task.getAssignedRobot().getRobotID());
            list1.add(task);
        }
    }

    /**
     * method retrieves a robot task from the array list by checking equality of the task name with the name of a task in the array list
     *
     * @param task the robot task instance to be retrieved from the array list
     */
    public RobotTask getRobotTaskFromList(RobotTask task) {
        RobotTask robotTask = null;
        int index = 0;
        for (RobotTask rt : taskList) {
            if (rt.getTaskName().equals(task.getTaskName()))
                robotTask = taskList.get(index);
            index++;
        }
        return robotTask;
    }

    /**
     * retrieves the Array List(value) associated with the key in the Hash Map
     *
     * @param robotID the key whose value need to be retrieved
     */
    public ArrayList<RobotTask> getRobotTaskFromMap(int robotID) {
        return tasksMap.get(robotID);
    }

    /**
     * deletes the specified task from both the Array List and Hash Map
     *
     * @param robotID the id that retrieves the Array List from the Hash Map from which the robot task is to be deleted
     * @param task    the task to be deleted from the Array List and Hash Map
     */
    public void deleteTask(int robotID, RobotTask task) {
        int index = 0;
        for (RobotTask rt : taskList) {
            if (task.getTaskName().equals(rt.getTaskName())) {
                taskList.remove(index);
            }
            index++;
        }

        if (tasksMap.containsKey(robotID)) {
            ArrayList<RobotTask> list = tasksMap.get(robotID);
            for (RobotTask rt : list) {
                if (rt.getTaskName().equals(task.getTaskName()))
                    list.remove(task);
            }
        }
    }

    /**
     * prints the contents of the Array List passed as a parameter
     *
     * @param tasksList the list to be printed
     */
    public void displayListContents(ArrayList tasksList) {
        int index = 1;
        for (RobotTask rt : taskList) {
            System.out.println(index + " " + rt);
            index++;
        }
    }

    /**
     * prints out the contents of the tasksMap Hash Map by printing the robotID(keys) and the associated Array List(values associated with
     * the ids(keys) in the map)
     */
    public void displayRobotAndRobotTasks() {
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

