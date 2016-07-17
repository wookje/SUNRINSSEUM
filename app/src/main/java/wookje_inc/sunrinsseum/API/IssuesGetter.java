package wookje_inc.sunrinsseum.API;

import android.util.Log;

import com.google.gson.Gson;

public class IssuesGetter {
    public IssuesGetter() {}
    private String url = "http://unifox.kr:31337/api/issues/1/";

    public Issues[] Get(int Idx) {
        String json_str = "";

        try {
            json_str = new JsonGet().execute(url).get();
        } catch(Exception e) {
            e.printStackTrace();
        }
        Log.e("msg", "json_str : " + json_str);
        IssuesJson[] info_arr = new Gson().fromJson(json_str, IssuesJson[].class);

        int arr_size = info_arr.length;

        Log.d("msg", "arrsize : " + arr_size);
        Issues[] arr = new Issues[arr_size];
        for (int i = 0; i < arr_size; i++) {
            Issues issues = new Issues();
            issues.topic = info_arr[i].getTopic();
            issues.news_link = info_arr[i].getNews_link();
            arr[i] = issues;
            Log.d("msg", arr[i].topic);
        }

        return arr;
    }
}
