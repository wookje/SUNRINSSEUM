package wookje_inc.sunrinsseum.Item;

public class DebateListviewitem {
    private int image;
    private String name;

    public int getImage() { return image; }
    public String getName() { return name; }

    public DebateListviewitem() { }

    public DebateListviewitem(int image, String name){
        this.image = image;
        this.name = name;
    }
}