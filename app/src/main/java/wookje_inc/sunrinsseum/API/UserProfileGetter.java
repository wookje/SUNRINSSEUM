package wookje_inc.sunrinsseum.API;

import android.util.Log;

import com.google.gson.Gson;

public class UserProfileGetter {
    public UserProfileGetter() {}
    private String url = "http://unifox.kr:31337/api/usersp/";

    public UserProfile Get(int Id) {
        String json_str = "";

        try {
            json_str = new JsonGet().execute(url+Id+"/").get();
        } catch(Exception e) {
            e.printStackTrace();
        }
        UserProfileJson json_userProfile = new Gson().fromJson(json_str, UserProfileJson.class);

        Log.d("json", json_str);

        UserProfile ret_userProfile = new UserProfile();
        ret_userProfile.username = json_userProfile.getUsername();
        ret_userProfile.email = json_userProfile.getEmail();
        ret_userProfile.sex = json_userProfile.getSex();
        //ret_userProfile.image_url = url + json_userProfile.getImage_url();

        return ret_userProfile;
    }

}
