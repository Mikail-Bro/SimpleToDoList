// ToDoListApp.java class
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    // Constructor
    public ToDoListApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to display the menu 
    public void displayMenu() {
        System.out.println("\n ~~~To-Do List Application~~~");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View All Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to add a task
    public void addTask() {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("The task was added successfully!");
    }

    // Method to delete a task
    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks! Nothing to delete!");
            return;
        }

        System.out.println("Available Tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter the task number to delete: ");
        int taskNumber;
        while (true) {
            try {
                taskNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Please, enter the task number!");
                scanner.nextLine();
            }
        }

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }

        System.out.println("Available Tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter the task number you completed: ");
        int taskNumber;
        while (true) {
            try {
                taskNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Please, enter the task number!");
                scanner.nextLine();
            }
        }
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to display all tasks
    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks! Nothing to delete!");
        } else {
            System.out.println("Your To-Do List: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to run the application
    public void run() {
        while (true) {
            displayMenu();
            int command;
            while(true) {
                try {
                command = scanner.nextInt();
                scanner.nextLine(); 
                break;
                } catch (Exception e) {
                    System.out.println("Invalid choice. Please enter command number!");
                    scanner.nextLine();
                }
            }
            switch (command) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    viewAllTasks();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}