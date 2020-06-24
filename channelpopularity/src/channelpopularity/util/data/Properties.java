package channelpopularity.util.data;

import channelpopularity.util.exception.NegativeLikesOrDislikes;

public class Properties {

    /**
     * defines and keeps account of all the details of a video
     * 
     * @author - Rohit Mahendra Dhuri
     */

    public int views, likes, dislikes, popularityScore;

    /**
     * Constructor initializes the constants
     * 
     */
    public Properties() {
        views = likes = dislikes = popularityScore = 0;
    }

    /**
     * Updates the constants to their new values
     * 
     * @param - Integer values of views likes and dislikes
     */
    public void set(int views, int likes, int dislikes) throws NegativeLikesOrDislikes {
        this.views += views;
        this.likes += likes;
        this.dislikes += dislikes;

        if (this.likes < 0 || this.dislikes < 0) {
            throw new NegativeLikesOrDislikes(
                    "Decrease in likes or dislikes is more than the total number of likes or dislikes, respectively, for the video");
        }
    }

    /**
     * Calculates the popularity score of a video
     * 
     */
    public void calPopularityScoreVideo() {
        this.popularityScore = views + 2 * (likes - dislikes);
        if(this.popularityScore<0)
        {
            popularityScore=0;
        }
    }

    @Override
    public String toString() {
        return "Class: Properties, Data Members: [ views= " + views+ " likes= "+ likes+" dislikes= "+ dislikes + " popularityScore= "+ popularityScore+" ]";
    }
}