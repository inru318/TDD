import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Task> tasks;

    public Scheduler() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int calCostTime(){
        return tasks.getFirst().getTime();
    }

}
