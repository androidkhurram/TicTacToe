package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    // declare variable
    private LinearLayout linWithCom, linWithHum;
    private TextView txtBlinkTitle;
    private DatabaseHandler databaseHandler;
    private List<PlayerInfo> playerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing all views
        initializeViews();
        // initializing Database
        databaseHandler= new DatabaseHandler(this);
        playerInfo = databaseHandler.getAllPlayers();
        for (PlayerInfo info : playerInfo) {
            txtBlinkTitle.setText("Welcome"+" "+ info.getName());
        }
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txtBlinkTitle.startAnimation(anim);
        // onclick listener to perform action on easy level
        linWithCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        LevelOneActivity.class);
                startActivity(intent);
            }
        });
        // onclick listener to perform action on easy level
        linWithHum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        PlayerDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    // initialize all views
    private void initializeViews() {
        linWithCom = (LinearLayout) findViewById(R.id.lin_withcom);
        linWithHum = (LinearLayout) findViewById(R.id.lin_withhum);
        txtBlinkTitle = (TextView) findViewById(R.id.txtHeading);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
