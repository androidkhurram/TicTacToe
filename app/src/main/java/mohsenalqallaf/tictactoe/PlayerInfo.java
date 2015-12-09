package mohsenalqallaf.tictactoe;

public class PlayerInfo {
	
	//private variables
	int _id;
	String _user_name;
	String _email_id;
	
	// Empty constructor
	public PlayerInfo(){
		
	}
	// constructor
	public PlayerInfo(int id, String name, String _phone_number){
		this._id = id;
		this._user_name = name;
		this._email_id = _phone_number;
	}
	
	// constructor
	public PlayerInfo(String name, String _phone_number){
		this._user_name = name;
		this._email_id = _phone_number;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this._user_name;
	}
	
	// setting name
	public void setName(String name){
		this._user_name = name;
	}
	
	// getting email id
	public String getEmailId(){
		return this._email_id;
	}
	
	// setting email id
	public void setEmailId(String phone_number){
		this._email_id = phone_number;
	}
}
