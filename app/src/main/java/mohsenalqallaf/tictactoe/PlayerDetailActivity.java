package mohsenalqallaf.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by modernit on 11/29/15.
 */
public class PlayerDetailActivity extends Activity {
    private Button b;
    private RadioGroup g1;
    private RadioGroup g2;
    private RadioButton rd;
    private String p1;
    private String p2;
    private final Context context = this;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_details);
        b = (Button) findViewById(R.id.play);
        g1 = (RadioGroup) findViewById(R.id.player1);
        g2 = (RadioGroup) findViewById(R.id.player2);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.click);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel = g1.getCheckedRadioButtonId();
                rd = (RadioButton) findViewById(sel);
                p1 = rd.getText().toString();

                sel = g2.getCheckedRadioButtonId();
                rd = (RadioButton) findViewById(sel);
                p2 = rd.getText().toString();
                mediaPlayer.start();
                Intent i = new Intent(context, LevelTwoActivity.class);
                i.putExtra("Player1", p1);
                i.putExtra("Player2", p2);
                startActivity(i);
            }
        });

    }

}