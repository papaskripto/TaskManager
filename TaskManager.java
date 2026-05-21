import java.util.ArrayList;

public class TaskManager {

	private ArrayList<Task> tasks;

	public TaskManager () {
		this.tasks = new ArrayList<>();
	}

	public void addTask (Task task) {
		if (tasks.contains (task)) {
			System.out.println ("Task exists already!");
		} else {
			tasks.add (task);
			System.out.println ("Task added successfully!");
		}
	}

	public void deleteTask (Task task) {
		if (tasks.contains (task)) {
			tasks.remove (task);
		} else {
			System.out.println ("Task not found!");
		}
	}

	public ArrayList<Task> listAllTasks () {
		return tasks;
	}

	public static void main (String [] args) {
		Task cook = new Task ("Make lunch", false);
		Task clean = new Task ("Clean the room!", true);
		TaskManager tm = new TaskManager ();
		tm.addTask (cook);
		tm.addTask (clean);
		tm.deleteTask (clean);
		System.out.println (tm.listAllTasks ());
	}
}
