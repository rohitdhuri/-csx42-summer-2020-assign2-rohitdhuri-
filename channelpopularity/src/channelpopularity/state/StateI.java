package channelpopularity.state;
import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;


public interface StateI {    

    void addVideo(String vName, ChannelContext c, Results result);
    void removeVideo(String vName, ChannelContext c, Results result);
    void adRequest(String vName, Integer length, ChannelContext c, Results result);
    void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c, Results result);

}
