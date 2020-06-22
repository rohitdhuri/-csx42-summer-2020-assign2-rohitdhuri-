package channelpopularity.state;

import channelpopularity.state.StateName;
import channelpopularity.context.ChannelContext;
import channelpopularity.util.data.Properties;

public abstract class AbstractState implements StateI {
    @Override
    public void addVideo(String vName, ChannelContext c) {
        if (c.getVideoData().containsKey(vName)) {
            // THROWS EXCEPTION
            System.out.println("Video " + vName + " already exists.\n exiting..");
            System.exit(0);
        } else {
            c.getVideoData().put(vName, new Properties());
            System.out.println("\n videos hashmap " + c.getVideoData());
        }
        c.updateChannelPopularity();
        System.out.println("\nCurrent state " + c.getCurrentState());

    }

    @Override
    public void removeVideo(String vName, ChannelContext c) {
        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().remove(vName);
            System.out.println("\n videos hashmap " + c.getVideoData() + " "+ c.channelPopularityScore);

        } else {
            // Throw Exception
            System.out.println("Video not found. \n exiting..");
            System.exit(0);
        }
        c.updateChannelPopularity();
        System.out.println("\nCurrent state " + c.getCurrentState());

    }

    @Override
    public void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c) {

        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().get(vName).set(views, likes, dislikes);
            c.getVideoData().get(vName).calPopularityScoreVideo();
        } else {
            // THROWS EXCEPTION
            System.err.println("Video dosent exist.");
        }

        c.updateChannelPopularity();
        System.out.println("\nCurrent state " + c.getCurrentState());

    }

}
