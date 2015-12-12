package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by modernit on 12/9/15.
 */
public class SignUpActivity extends Activity{
    // declare variables
    private Button btnYes, btnNo;
    private DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        // initializeViews views
        initializeViews();
        // initializing Database and bean class
        databaseHandler = new DatabaseHandler(this);
        // implementing onclick listeners
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                UserLogs logs= new UserLogs();
                logs.setAction("User clicked on have account.");
                databaseHandler.createUserLogs(logs);
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                UserLogs logs= new UserLogs();
                logs.setAction("User clicked on don't have account.");
                databaseHandler.createUserLogs(logs);
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initializeViews()
    {
        btnYes = (Button)findViewById(R.id.btn_yes);
        btnNo = (Button)findViewById(R.id.btn_no);
    }
}
