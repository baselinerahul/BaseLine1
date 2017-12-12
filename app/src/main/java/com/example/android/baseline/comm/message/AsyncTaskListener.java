package com.example.android.baseline.comm.message;

/**
 * Created by Palo12 on 25-10-2017.
 */

public interface AsyncTaskListener {
    public void onPreExecute();
    public String doInBackground(Object... params);
    public String httpGetRequest(String urlPath) ;
    public String httpPostRequest(String urlPath, Object request) ;
    public void onPostExecute(String result) ;
    public void execute(Object... pararms);
}
