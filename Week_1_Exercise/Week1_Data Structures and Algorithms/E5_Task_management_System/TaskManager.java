
import java.util.Scanner;

public class TaskManager {
    Task head;

    void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    Task searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void traverseTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Status: " + temp.status);
            temp = temp.next;
        }
    }

    void deleteTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            head = head.next;
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String addStatus = scanner.nextLine();
                    taskManager.addTask(addId, addName, addStatus);
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = taskManager.searchTask(searchId);
                    if (foundTask != null) {
                        System.out.println("Task ID: " + foundTask.taskId + ", Task Name: " + foundTask.taskName + ", Status: " + foundTask.status);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    taskManager.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
