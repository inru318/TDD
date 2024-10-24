import java.util.List;

public class Task {
    private int id;
    private int time;
    private List<Integer> dependencies;

    public Task(int id, int time, List<Integer> dependencies) {
        this.id = id;
        this.time = time;
        this.dependencies = dependencies;
    }

    public int getTime() {
        return time;
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

}
