package wookje_inc.sunrinsseum.Item;

public class NoticeListviewitem {
    private int image;
    private String name;
    private String msg;
    private String time;

    public int getImage() { return image; }
    public String getName() { return name; }
    public String getMsg() { return msg; }
    public String getTime() { return time; }

    public NoticeListviewitem() { }

    public NoticeListviewitem(int image, String name, String time, String msg){
        this.image = image;
        this.name = name;
        this.time = time;
        this.msg = msg;
    }
}