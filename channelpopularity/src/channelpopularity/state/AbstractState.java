package channelpopularity.state;

import channelpopularity.state.StateName;
import channelpopularity.context.ChannelContext;
import channelpopularity.util.data.Properties;

public abstract class AbstractState implements StateI {
    @Override
    public void addVideo(String vName, ChannelContext c) {
        System.out.println(c.getCurrentState()+"__VIDEO_ADDED::"+vName);
        if (c.getVideoData().containsKey(vName)) {
            // THROWS EXCEPTION
            System.out.println("Video " + vName + " already exists.\n exiting..");
            System.exit(0);
        } else {
            c.getVideoData().put(vName, new Properties());
          //  System.out.println("\n videos hashmap " + c.getVideoData());
        }
        c.updateChannelPopularity();

    }

    @Override
    public void removeVideo(String vName, ChannelContext c) {
        System.out.println(c.getCurrentState()+"__VIDEO_REMOVED::"+vName);
        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().remove(vName);
       //     System.out.println("\n videos hashmap " + c.getVideoData() + " "+ c.channelPopularityScore);

        } else {
            // Throw Exception
            System.out.println("Video not found. \n exiting..");
            System.exit(0);
        }
        c.updateChannelPopularity();
    }

    @Override
    public void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c) {
        System.out.println(c.getCurrentState()+"__POPULARITY_SCORE_UPDATE::"+c.channelPopularityScore);
        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().get(vName).set(views, likes, dislikes);
            c.getVideoData().get(vName).calPopularityScoreVideo();
        } else {
            // THROWS EXCEPTION
            System.err.println("Video dosent exist.");
        }

        c.updateChannelPopularity();
    }

}
