import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (tasks.remove(taskId) == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }

    public void updateName(String taskId, String name) {
        getRequiredTask(taskId).setName(name);
    }

    public void updateDescription(String taskId, String description) {
        getRequiredTask(taskId).setDescription(description);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    private Task getRequiredTask(String taskId) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        return task;
    }
}
