package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WinGame extends Activity {
    private TextView winn;
    private Button b;
    private final Context context = this;
    private ImageView im;
    private MediaPlayer mediaPlayerWinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_layout);
        mediaPlayerWinning = MediaPlayer.create(getApplicationContext(), R.raw.winning);
        mediaPlayerWinning.start();
        Intent intent = getIntent();
        String win = intent.getStringExtra("winner");
        winn = (TextView) findViewById(R.id.wintxt);
        b = (Button) findViewById(R.id.back);
        im = (ImageView) findViewById(R.id.trophy);
        im.setImageResource(R.drawable.trophy);
        winn.setText(win);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(context, PlayerDetailActivity.class);
                startActivity(i);
            }
        });
    }
}
