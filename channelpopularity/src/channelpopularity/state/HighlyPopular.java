package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;

public class HighlyPopular extends AbstractState {

    /**
     * Contains operatins specific to this state
     * 
     * @author - Rohit Mahendra Dhuri
     */

    /**
     * This function updates the metrics of any video
     * 
     * @param - A string containing name of video and three integer values: views,
     *          likes and dislikes. Also ChannelConetxt object and results object.
     */
    @Override
    public void adRequest(String vName, Integer length, ChannelContext c, Results result) {
        if (length >= 1 && length <= 30) {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::APPROVED" + "\n");
        } else {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::REJECTED" + "\n");
        }
    }

}
