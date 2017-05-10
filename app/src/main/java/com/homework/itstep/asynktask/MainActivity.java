package com.homework.itstep.asynktask;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_repsonse);

    }

    @Override
    protected void onResume() {
        super.onResume();

        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);

    }

    protected void updateView(String info) {
        if (info != null) {
            tv.setText(info);
        } else {
            tv.setText("problem downloading");
        }
    }
}
