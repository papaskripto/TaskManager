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
}
