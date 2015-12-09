package mohsenalqallaf.tictactoe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "contactsManager";

	// Contacts table name
	private static final String TABLE_PLAYERS_LOGIN = "login";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_USER_NAME = "user_name";
	private static final String KEY_EMAIL_ID = "email_id";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PLAYERS_LOGIN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER_NAME + " TEXT,"
				+ KEY_EMAIL_ID + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS_LOGIN);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new player
	void addNewPlayer(PlayerInfo playerInfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USER_NAME, playerInfo.getName()); // PlayerInfo Name
		values.put(KEY_EMAIL_ID, playerInfo.getEmailId()); // PlayerInfo Phone
		System.out.println("new player value"+values);
		// Inserting Row
		db.insert(TABLE_PLAYERS_LOGIN, null, values);
		db.close(); // Closing database connection
	}

	// Getting single player Info
	PlayerInfo getPlayerInfo(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_PLAYERS_LOGIN, new String[] { KEY_ID,
						KEY_USER_NAME, KEY_EMAIL_ID}, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		PlayerInfo info = new PlayerInfo(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return player name
		return info;
	}
	
	// Getting All Player Names
	public List<PlayerInfo> getAllPlayers() {
		List<PlayerInfo> playerList = new ArrayList<PlayerInfo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_PLAYERS_LOGIN;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				PlayerInfo playerInfo = new PlayerInfo();
				playerInfo.setID(Integer.parseInt(cursor.getString(0)));
				playerInfo.setName(cursor.getString(1));
				playerInfo.setEmailId(cursor.getString(2));
				// Adding players to list
				playerList.add(playerInfo);
			} while (cursor.moveToNext());
		}

		// return players list
		return playerList;
	}

	// Updating single player
	public int updatePlayerList(PlayerInfo playerInfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_USER_NAME, playerInfo.getName());
		values.put(KEY_EMAIL_ID, playerInfo.getEmailId());

		// updating row
		return db.update(TABLE_PLAYERS_LOGIN, values, KEY_ID + " = ?",
				new String[] { String.valueOf(playerInfo.getID()) });
	}

	// Deleting single player from list
	public void deletePlayer(PlayerInfo playerInfo) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_PLAYERS_LOGIN, KEY_ID + " = ?",
				new String[] { String.valueOf(playerInfo.getID()) });
		db.close();
	}


	// Getting players Count
	public int getPlayersCount() {
		String countQuery = "SELECT  * FROM " + TABLE_PLAYERS_LOGIN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
