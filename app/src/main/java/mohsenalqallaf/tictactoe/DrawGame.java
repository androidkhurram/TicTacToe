package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrawGame extends Activity {
    private Button back;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_layout);
        back = (Button) findViewById(R.id.drawBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(context, PlayerDetailActivity.class);
                startActivity(i);
            }
        });
    }
}