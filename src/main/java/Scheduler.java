import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Scheduler {
    private List<Task> tasks;

    public Scheduler() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(List<Task> taskList) {
        tasks.addAll(taskList);
    }

    public int calCostTime(){
        ArrayList<Integer> forks = new ArrayList<>();
        ArrayList<Integer> roads = new ArrayList<>();
        int nowIndex = 0;
        int roadIndex = 0;
        roads.add(0);
        while(true) {
            if(tasks.get(nowIndex).getDependencies() != null) {
                if(tasks.get(nowIndex).getDependencies().size() > 1) {
                    roads.set(roadIndex, roads.get(roadIndex) + tasks.get(nowIndex).getTime());
                    for(Integer dependence : tasks.get(nowIndex).getDependencies()) {
                        forks.add(dependence);
                        // 有 fork 時要備份 fork 前總計的時間
                        if(dependence != tasks.get(nowIndex).getDependencies().size()-1) {
                            roads.add(roads.get(roadIndex));
                        }
                    }
                    nowIndex = forks.remove(forks.size()-1);
                }
                else if (tasks.get(nowIndex).getDependencies().size() == 1) {
                    int totalTime = tasks.get(nowIndex).getTime();
                    roads.set(roadIndex, roads.get(roadIndex) + totalTime);
                    nowIndex = tasks.get(nowIndex).getDependencies().getFirst() - 1;
                }
            }
            else {
                roads.set(roadIndex, roads.get(roadIndex) + tasks.get(nowIndex).getTime());
                if(!forks.isEmpty()){
                    nowIndex = forks.remove(forks.size()-1);
                    roadIndex++;
                }
                else{
                    break;
                }
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
