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

    public RobotTask getRobotTaskFromList(RobotTask taskName) {
        RobotTask robotTask=null;
        int index=0;
        for(RobotTask rt:taskList){
            if(rt.getTaskName().equals(taskName.getTaskName()))
            robotTask = taskList.get(index);
            index++;
        }
        return robotTask;
    }

    public ArrayList<RobotTask> getRobotTaskFromMap(int robotID){
     return tasksMap.get(robotID);
    }

    public ArrayList<RobotTask> getTaskList() {
        return taskList;
    }

    public void deleteTask(int robotID,RobotTask task) {
        //taskList.remove(robotID);
        if(tasksMap.get(robotID).equals(robotID)){
            ArrayList<RobotTask> list=tasksMap.get(robotID);
            for(RobotTask rt:list) {
                if (task.getTaskName().equals(rt.getTaskName())){
                    list.remove(task);
                }
            }
        }
    }

    public void displayListContents(ArrayList tasksList){
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

//test out all methods
//good commenting
