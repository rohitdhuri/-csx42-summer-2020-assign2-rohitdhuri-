package channelpopularity.util;

public class VideoProperties{

    public int views, likes, dislikes;
    public String name;

    public VideoProperties() {
        views=likes=dislikes=0;
    }

    public void set(int views, int likes, int dislikes){
        this.views+= views;
        this.likes+=likes;
        this.dislikes+=dislikes;
    }


}