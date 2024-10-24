import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Scheduler {
    private List<Task> tasks;
    private List<Integer> roads;

    public Scheduler() {
        this.tasks = new ArrayList<>();
        this.roads = new ArrayList<>();
        roads.add(0);
    }

    public void addTask(List<Task> taskList) {
        tasks.addAll(taskList);
    }

    public int calCostTime(){
        int nowIndex = 0;
        int roadIndex = 0;
        while(true) {
            if(tasks.get(nowIndex).getDependencies() != null) {
                int totalTime = tasks.get(nowIndex).getTime();
                roads.set(roadIndex, roads.get(roadIndex) + totalTime);
                nowIndex = tasks.get(nowIndex).getDependencies().getFirst() - 1;
            }
            else {
                roads.set(roadIndex, roads.get(roadIndex) + tasks.get(nowIndex).getTime());
                break;
            }
        }
        for (Task task : tasks) {
            if(task.getDependencies() == null) {
                roads.add(task.getTime());
            }
        }
        return Collections.max(roads);
    }

}
