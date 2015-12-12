package mohsenalqallaf.tictactoe;

public class UserLogs {

	int id;
	String action;
	String created_at;

	// constructors
	public UserLogs() {
	}

	public UserLogs(String user_action) {
		this.action = user_action;
	}

	public UserLogs(int id, String user_action) {
		this.id = id;
		this.action = user_action;
	}

	// setters
	public void setId(int id) {
		this.id = id;
	}

	public void setAction(String user_action) {
		this.action = user_action;
	}

	// getters
	public long getId() {
		return this.id;
	}

	public String getAction() {
		return this.action;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
