public class Task {

	private String content;
	private boolean status;

	public Task (String content, boolean status) {
		this.content = content;
		this.status = status;
	}

	public String getContent () {
		return this.content;
	}

	public void setContent (String newContent) {
		this.content = newContent;
	}

	public boolean getStatus () {
		return this.status;
	}

	public void setStatus (boolean newStatus) {
		this.status = newStatus;
	}

	public String toString () {
		return this.content + " : " + this.status;
	}
}
