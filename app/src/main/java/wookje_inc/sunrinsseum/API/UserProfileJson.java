package wookje_inc.sunrinsseum.API;

import android.graphics.drawable.Drawable;

public class UserProfileJson {
    private String username, email;
    private String image_url;
    private boolean sex;
    private Drawable profile_img;
    private String url;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }

    public void setSex(boolean sex) { this.sex = sex; }
    public boolean getSex() { return this.sex; }

    public void setProfile_img(Drawable profile_img) { this.profile_img = profile_img; }
    public Drawable getProfile_img() { return this.profile_img; }

    public void setImage_url(String image_url) { this.image_url = image_url; }
    public String getImage_url() { return this.image_url; }

    public void setUrl(String url) { this.url = url; }
    public String getUrl() { return this.url; }
}
