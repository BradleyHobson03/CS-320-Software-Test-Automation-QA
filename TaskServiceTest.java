import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;
    private Task task;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        task = new Task("T100", "Inspection", "Inspect conveyor system");
    }

    @Test
    void testAddTask() {
        service.addTask(task);
        assertSame(task, service.getTask("T100"));
    }

    @Test
    void testDuplicateIdRejected() {
        service.addTask(task);
        Task duplicate = new Task("T100", "Repair", "Repair conveyor system");
        assertThrows(IllegalArgumentException.class,
                () -> service.addTask(duplicate));
    }

    @Test
    void testDeleteTask() {
        service.addTask(task);
        service.deleteTask("T100");
        assertNull(service.getTask("T100"));
    }

    @Test
    void testDeleteMissingTaskRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteTask("missing"));
    }

    @Test
    void testUpdateName() {
        service.addTask(task);
        service.updateName("T100", "PM Inspection");
        assertEquals("PM Inspection", service.getTask("T100").getName());
    }

    @Test
    void testUpdateDescription() {
        service.addTask(task);
        service.updateDescription("T100", "Inspect and document conveyor condition");
        assertEquals("Inspect and document conveyor condition",
                service.getTask("T100").getDescription());
    }

    @Test
    void testUpdateMissingTaskRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateName("missing", "Updated"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateDescription("missing", "Updated description"));
    }

    @Test
    void testInvalidNameUpdateRejected() {
        service.addTask(task);
        assertThrows(IllegalArgumentException.class,
                () -> service.updateName("T100", "123456789012345678901"));
    }

    @Test
    void testInvalidDescriptionUpdateRejected() {
        service.addTask(task);
        String invalid = "123456789012345678901234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class,
                () -> service.updateDescription("T100", invalid));
    }
}
