import java.util.List;

public class Task {
    private int id;
    private int time;
    private List<Integer> dependencies;

    public Task(int id, int time, List<Integer> dependencies) throws Exception{
        this.id = id;
        this.time = time;
        this.dependencies = dependencies;
        if (hasCycle(this.id)) {
            throw new Exception("Should be directed Acyclic Graph");
        }
    }

    public int getTime() {
        return time;
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

    private boolean hasCycle(int taskId) {
        if (dependencies != null) {
            for (Integer dependency : dependencies) {
                if (dependency <= taskId) {
                    return true;
                }
            }
        }
        return false;
    }

}
