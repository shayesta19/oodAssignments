import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class RobotTask {

    private int ID;
    private String taskName;
    private String date;
    private Date dateFormat;
    private LocalTime timeFormat;
    private Robot assignedRobot;
    private String objective;
    private String time;

    public RobotTask(int ID, String taskName, String date, String time, Robot assignedRobot, String objective) {
        this.ID = ID;
        this.taskName = taskName;
        this.date = date;
        this.assignedRobot = assignedRobot;
        this.objective = objective;
        this.time = time;
    }

    public Date getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(Date dateFormat) {
        this.dateFormat = dateFormat;
    }

    public LocalTime getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(LocalTime timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) throws ParseException {
        this.time = time;
//        String fmt ="HH:mm:ss";
//        DateFormat df=new SimpleDateFormat(fmt);
//        Date dt=df.parse(time);
//        DateFormat tdf=new SimpleDateFormat("HH:mm:ss");
        // timeFormat=LocalTime.parse(time);
        setTimeFormat(LocalTime.parse(time));
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = date;
        String fmt = "MM-dd-yyyy";
        DateFormat df = new SimpleDateFormat(fmt);
        Date dt = df.parse(date);
        setDateFormat(dt);
    }

    public String formattedString() {
//        String date = String.format("%1$tm-%1$te-%1$ty", getDateFormat());
//        String time = String.format("%1$tH:%1$tM:%1$ts", getTimeFormat());
        return String.format("Task ID: %1$d | Task Name: %2$7s, | Objective: %3$10s | start date: %4$s | start time: %5$s ", getID(), getTaskName(), getObjective(), getDate(), getTime());
    }

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

    @Override
    public String toString() {
        return this.formattedString();
    }
}
