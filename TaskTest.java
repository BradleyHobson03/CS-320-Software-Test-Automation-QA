import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testValidTask() {
        Task task = new Task("1234567890", "Maintenance",
                "Complete scheduled maintenance task");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Maintenance", task.getName());
        assertEquals("Complete scheduled maintenance task", task.getDescription());
    }

    @Test
    void testTenCharacterIdAccepted() {
        Task task = new Task("1234567890", "Task", "Description");
        assertEquals("1234567890", task.getTaskId());
    }

    @Test
    void testElevenCharacterIdRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("12345678901", "Task", "Description"));
    }

    @Test
    void testNullIdRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(null, "Task", "Description"));
    }

    @Test
    void testNameBoundary() {
        Task task = new Task("1", "12345678901234567890", "Description");
        assertEquals(20, task.getName().length());
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "123456789012345678901", "Description"));
    }

    @Test
    void testNullNameRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", null, "Description"));
    }

    @Test
    void testFiftyCharacterDescriptionAccepted() {
        String description = "12345678901234567890123456789012345678901234567890";
        Task task = new Task("1", "Task", description);
        assertEquals(50, task.getDescription().length());
    }

    @Test
    void testFiftyOneCharacterDescriptionRejected() {
        String description = "123456789012345678901234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "Task", description));
    }

    @Test
    void testNullDescriptionRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "Task", null));
    }
}
