/* Singly Linked List: Each node points to the next node, and traversal is possible only in one direction.
Doubly Linked List: Each node points to both the next node and the previous node, allowing traversal in both directions.*/

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Adding tasks
        tms.addTask(new Task(1, "Complete project report", "Pending"));
        tms.addTask(new Task(2, "Submit expense report", "Completed"));
        tms.addTask(new Task(3, "Prepare presentation", "Pending"));

        // Traversing tasks
        System.out.println("All Tasks:");
        tms.traverseTasks();

        // Searching for a task
        Task task = tms.searchTask(2);
        System.out.println("Search Result: " + (task != null ? task : "Task not found"));
        // Deleting a task
        tms.deleteTask(1);

        // Traversing tasks after deletion
        System.out.println("All Tasks After Deletion:");
        tms.traverseTasks();
    }

    // Node class for linked list
    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagementSystem() {
        head = null;
    }

    // Add a new task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks to display.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }
}

class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
// Analysis
/*
 * Time Complexity:
 * Add Operation: O(n) - Inserting at the end requires traversing the list. For
 * adding at the beginning, it's O(1).
 * Search Operation: O(n) - Linear search through the list.
 * Traverse Operation: O(n) - Visiting each node once.
 * Delete Operation: O(n) - Finding the node requires linear time
 */

/*
 * Advantages of Linked Lists over Arrays:
 * Dynamic Size: Linked lists can grow and shrink dynamically, unlike arrays
 * which have a fixed size.
 * Efficient Insertions/Deletions: Insertions and deletions are more efficient
 * in linked lists as they involve adjusting pointers, rather than shifting
 * elements as in arrays.
 */