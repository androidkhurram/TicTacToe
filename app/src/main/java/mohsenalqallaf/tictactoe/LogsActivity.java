package mohsenalqallaf.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by modernit on 12/12/15.
 */
public class LogsActivity extends Activity{
    private ListView list;
    private CustomListAdaptor adaptor;
    private DatabaseHandler databaseHandler;
    private ArrayList<UserLogs> userLogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_activity);
        // initialize Views
        list = (ListView)findViewById(R.id.list_logs);
        databaseHandler= new DatabaseHandler(this);
        userLogs = databaseHandler.getAllLogs();
        adaptor=new CustomListAdaptor( this, userLogs );
        list.setAdapter(adaptor);
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        Formatter.formatFileSize(this, availableBlocks * blockSize);

    }
}
