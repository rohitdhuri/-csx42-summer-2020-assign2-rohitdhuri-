package channelpopularity.state;

import channelpopularity.context.ContextI;
import channelpopularity.util.data.VideoData;

public class Unpopular implements StateI {

    private ContextI channelCObj;
    private VideoData vd;

    public Unpopular(ContextI inChannelCObj, VideoData inVd) {
        channelCObj = inChannelCObj;
        vd = inVd;

    }

    @Override
    public void addVideo(String vName) {
        if (vd.getVideoData().containsKey(vName)) {
            // THROWS EXCEPTION
            System.out.println("Video " + vName + " already exists.\n exiting..");
            System.exit(0);
        } else {
            vd.addVideo(vName);
        }
    }

    @Override
    public void removeVideo(String vName) {
        if (vd.getVideoData().containsKey(vName)) {
            vd.removeVideo(vName);
        } else {
            // Throw Exception
            System.out.println("Video not found. \n exiting..");
            System.exit(0);
        }
    }

    @Override
    public void adRequest() {
    }

    @Override
    public void metrics() {
    }

}