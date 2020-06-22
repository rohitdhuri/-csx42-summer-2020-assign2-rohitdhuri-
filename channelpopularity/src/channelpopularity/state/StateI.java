package channelpopularity.state;
import channelpopularity.context.ChannelContext;

public interface StateI {

    void addVideo(String vName, ChannelContext c);
    void removeVideo(String vName, ChannelContext c);
    void adRequest(ChannelContext c);
    void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c);

}
