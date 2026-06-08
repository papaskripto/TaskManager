public class Main {
	public static void main (String [] args) {
		Task cook = new Task ("Make lunch", false);
		Task clean = new Task ("Clean the room!", true);
		Task sleep = new Task ("Sleep now", false);
		TaskManager tm = new TaskManager ();
		tm.addTask (cook);
		tm.addTask (clean);
		tm.addTask (sleep);
		tm.deleteTask (clean);
		System.out.println (tm.listAllTasks ());
	}
}
