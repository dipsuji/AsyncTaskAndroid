package suji.dip.asynctaskandroid;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // defining variables
    private Button parseJsonData;
    private TextView jsonResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding id from XML
        jsonResultTextView = findViewById(R.id.json_result);
        parseJsonData = findViewById(R.id.button_parse_data);

        parseJsonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJsonData();
            }
        });
    }

    private void parseJsonData() {
        // get data from server by aysn tas...kkkk
        new DownloadJSONDataTask(mHandler).execute("http://time.jsontest.com/");
    }


    /**
     * receive data from handler
     */
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage.......");
            String string = (String) msg.obj;
            jsonResultTextView.setText(string);
        }
    };

}
