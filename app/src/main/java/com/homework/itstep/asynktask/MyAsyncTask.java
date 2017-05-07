package com.homework.itstep.asynktask;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;

/**
 * Created by Mike on 04.05.2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

    private final static String TAG = MyAsyncTask.class.getSimpleName();

    private MainActivity mActivity;


    public MyAsyncTask(String s, MainActivity mainActivity) {
        Log.d("Fsds", "AsyncTask created" + s);
        mActivity = mainActivity;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d("Fsds", "On PreExecute " + Thread.currentThread().getName());
        mActivity.showProgressBar();


    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected Void doInBackground(Integer[] params) {

        Log.d("Fsds", "Do in Background" + Thread.currentThread().getName());

        MainActivity.User user = null;

        try {

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                //new MainActivity.User("Vasya" + i, 10 + new Random().nextInt() * 10);
                publishProgress(i);
                mActivity.onUserReceived(new MainActivity.User("Vasya" + i, 10 + new Random().nextInt() * 10));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("Fsds", "Job Done " + Thread.currentThread().getName());
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);

        Log.d("Fsds", "OnPostExecute " + Thread.currentThread().getName());
        mActivity.hideProgressBar();
        //mActivity.onUserReceived(user);


    }
}
