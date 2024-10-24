import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Scheduler {
    private List<Task> tasks;
    private List<Integer> roads;

    public Scheduler() {
        this.tasks = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int calCostTime(){
        for (Task task : tasks) {
            if(task.getDependencies() == null) {
                roads.add(task.getTime());
            }
        }
        return Collections.max(roads);
    }

}
