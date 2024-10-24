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

    @Test
    public void multipleSingleTaskCase() throws Exception{
        Task createTask1 = new Task(1, 5, null);
        Task createTask2 = new Task(2, 9, null);
        Task createTask3 = new Task(3, 7, null);
        Task createTask4 = new Task(4, 3,null);
        Scheduler crerateScheduler = new Scheduler();
        crerateScheduler.addTask(createTask1);
        crerateScheduler.addTask(createTask2);
        crerateScheduler.addTask(createTask3);
        crerateScheduler.addTask(createTask4);
        assertEquals(9,crerateScheduler.calCostTime());
    }
}
