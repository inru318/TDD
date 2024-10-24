import java.util.Arrays;
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
        Task createTask = new Task(1, 5, null);
        Scheduler crerateScheduler = new Scheduler();
        crerateScheduler.addTask(createTask);
        assertEquals(5,crerateScheduler.calCostTime());
    }
}
