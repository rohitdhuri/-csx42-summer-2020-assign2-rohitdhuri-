package channelpopularity.util.data;

public class Properties {

    public int views, likes, dislikes, popularityScore;
    public String name;

    public Properties() {
        views = likes = dislikes = popularityScore = 0;
    }

    public void set(int views, int likes, int dislikes) {
        this.views += views;
        this.likes += likes;
        this.dislikes += dislikes;

    }

    public void calPopularityScoreVideo() {
        this.popularityScore = views + 2 * (likes - dislikes);
    }

}