package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by modernit on 12/8/15.
 */
public class LoginActivity extends Activity {
    // declare all views
    private EditText editUserName, editEmailId;
    private Button btnSubmit, btnCancel;
    private PlayerInfo playerInfo;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DatabaseHandler(this);
        playerInfo = new PlayerInfo();
        // initializeViews all Views
        initializeViews();
        // onClick Listener for sign in button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerInfo.setName(editUserName.getText().toString());
                playerInfo.setEmailId(editEmailId.getText().toString());
                db.addNewPlayer(playerInfo);

                if (editEmailId.getText().toString().isEmpty() ||
                        editUserName.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),
                            "Please Enter Your Record First!!!", Toast.LENGTH_LONG).show();
                    UserLogs logs= new UserLogs();
                    logs.setAction("User entered wrong credentials.");
                    db.createUserLogs(logs);
                } else {
                    UserLogs logs= new UserLogs();
                    logs.setAction("User successfully loged in.");
                    db.createUserLogs(logs);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        // onClick Listener for cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogs logs= new UserLogs();
                logs.setAction("User cancelled login screen.");
                db.createUserLogs(logs);
                finish();
            }
        });
    }

    // initialize all Views here in this method
    private void initializeViews() {
        editEmailId = (EditText) findViewById(R.id.edt_email_id);
        editUserName = (EditText) findViewById(R.id.edt_user_name);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }
}
