package channelpopularity.util.data;

import channelpopularity.util.exception.NegativeLikesOrDislikes;

public class Properties {

    public int views, likes, dislikes, popularityScore;
    public String name;

    public Properties() {
        views = likes = dislikes = popularityScore = 0;
    }

    public void set(int views, int likes, int dislikes) throws NegativeLikesOrDislikes {
        this.views += views;
        this.likes += likes;
        this.dislikes += dislikes;

        if(this.likes < 0 || this.dislikes <0){
            throw new NegativeLikesOrDislikes("Decrease in likes or dislikes is more than the total number of likes or dislikes, respectively, for the video");
        }
    }

    public void calPopularityScoreVideo() {
        this.popularityScore = views + 2 * (likes - dislikes);
    }

}