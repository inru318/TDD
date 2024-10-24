import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void createOneTask() throws Exception {
        Task createTask = new Task(1, 5, Arrays.asList(2, 3));
        assertEquals(5,createTask.getTime());
        assertEquals(Arrays.asList(2, 3),createTask.getDependencies());
    }

    @Test
    public void singleTaskCase() throws Exception{
        List<Task> createTasks = new ArrayList<>();
        createTasks.add(new Task(1, 5, null));
        Scheduler crerateScheduler = new Scheduler();
        crerateScheduler.addTask(createTasks);
        assertEquals(5,crerateScheduler.calCostTime());
    }

    @Test
    public void multipleSingleTaskCase() throws Exception{
        List<Task> createTasks = new ArrayList<>();
        createTasks.add(new Task(1, 5, null));
        createTasks.add(new Task(2, 9, null));
        createTasks.add(new Task(3, 7, null));
        createTasks.add(new Task(4, 3, null));
        Scheduler crerateScheduler = new Scheduler();
        crerateScheduler.addTask(createTasks);
        assertEquals(9,crerateScheduler.calCostTime());
    }
}
