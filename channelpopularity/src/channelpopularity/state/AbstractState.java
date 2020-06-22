package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;
import channelpopularity.util.data.Properties;

public abstract class AbstractState implements StateI {
    
    @Override
    public void addVideo(String vName, ChannelContext c, Results result) {
        result.storeOutput(c.getCurrentState() + "__VIDEO_ADDED::" + vName+"\n");
        if (c.getVideoData().containsKey(vName)) {
            // THROWS EXCEPTION
            System.out.println("Video " + vName + " already exists.\n exiting..");
            System.exit(0);
        } else {
            c.getVideoData().put(vName, new Properties());
            // System.out.println("\n videos hashmap " + c.getVideoData());
        }
        c.updateChannelPopularity();
        c.updateState();

    }

    @Override
    public void removeVideo(String vName, ChannelContext c, Results result) {
        result.storeOutput(c.getCurrentState() + "__VIDEO_REMOVED::" + vName+"\n"); 
        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().remove(vName);
            // System.out.println("\n videos hashmap " + c.getVideoData() + " "+
            // c.channelPopularityScore);

        } else {
            // Throw Exception
            System.out.println("Video not found. \n exiting..");
            System.exit(0);
        }
        c.updateChannelPopularity();
        c.updateState();
    }

    @Override
    public void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c, Results result) {

        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().get(vName).set(views, likes, dislikes);
            c.getVideoData().get(vName).calPopularityScoreVideo();
        } else {
            // THROWS EXCEPTION
            System.err.println("Video dosent exist.");
        }

        c.updateChannelPopularity();
        result.storeOutput(c.getCurrentState() + "__POPULARITY_SCORE_UPDATE::" + c.channelPopularityScore+"\n");
        c.updateState();

    }

}
