import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class RobotTask {

    private int ID;
    private String taskName;
    private LocalDateTime dateTime;
    private Robot assignedRobot;
    private String objective;

    public RobotTask(int ID, String taskName, LocalDateTime dateTime, Robot assignedRobot, String objective) {
        this.ID = ID;
        this.taskName = taskName;
        this.dateTime = dateTime;
        this.assignedRobot = assignedRobot;
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Robot getAssignedRobot() {
        return assignedRobot;
    }

    public void setAssignedRobot(Robot assignedRobot) {
        this.assignedRobot = assignedRobot;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof RobotTask)) return false;
//        RobotTask robotTask = (RobotTask) o;
//        return getID() == robotTask.getID() &&
//                getAssignedRobot() == robotTask.getAssignedRobot();
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(getID(), getAssignedRobot());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RobotTask)) return false;
        RobotTask robotTask = (RobotTask) o;
        return getAssignedRobot().equals(robotTask.getAssignedRobot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignedRobot());
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "RobotTask{" +
                "ID=" + ID +
                ", taskName='" + taskName + ", objective=" + objective + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
