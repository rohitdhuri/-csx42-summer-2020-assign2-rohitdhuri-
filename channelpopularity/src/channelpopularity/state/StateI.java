package channelpopularity.state;

public interface StateI {

    void addVideo(String vName);
    void removeVideo(String vName);
    void adRequest();
    void metrics(String vName, Integer views, Integer likes, Integer dislikes);

}
