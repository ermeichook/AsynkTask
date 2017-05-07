package com.homework.itstep.asynktask;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private View container;
    private TextView tv;

    private User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);
        tv = (TextView) findViewById(R.id.tv_name);
    }

    @Override
    protected void onResume() {
        super.onResume();


        MyAsyncTask myAsyncTask = new MyAsyncTask("Hello", this);
        myAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, 1);

//        try {
//            user = myAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, 1).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        Log.d("Fsds", "Resume " + Thread.currentThread().getName());

    }

    public void showProgressBar(){
        container.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        container.setVisibility(View.GONE);
    }

    public void onUserReceived(final User user){


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String currentText = tv.getText().toString();
                currentText = currentText + "\n" + "Name: " + user.name + " Age: " + user.age;
                tv.setText(currentText);
            }
        });

    }

    public static class User{
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


}
