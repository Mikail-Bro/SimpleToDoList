// Task class
public class Task {
    private String description;
    private boolean isCompleted;

    // Constructor 
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark completed tasks
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Override toString to display task properties 
    @Override
    public String toString() {
        return "Task " + description + " <Status: " + 
        (isCompleted ? "Completed" : "Pending") + ">";
    }
}