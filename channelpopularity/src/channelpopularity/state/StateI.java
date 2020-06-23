package channelpopularity.state;
import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;


public interface StateI {    

    void addVideo(String vName, ChannelContext c, Results result) throws VideoAlreadyExists;
    void removeVideo(String vName, ChannelContext c, Results result) throws VideoNotFound;
    void adRequest(String vName, Integer length, ChannelContext c, Results result);
    void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c, Results result) throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound;

}
