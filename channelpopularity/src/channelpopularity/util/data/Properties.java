package channelpopularity.util.data;

public class Properties{

    public int views, likes, dislikes;
    public String name;

    public Properties() {
        views=likes=dislikes=0;
    }

    public void set(int views, int likes, int dislikes){
        this.views+= views;
        this.likes+=likes;
        this.dislikes+=dislikes;
    }


}