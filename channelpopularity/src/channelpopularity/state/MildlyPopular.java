package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;

public class MildlyPopular extends AbstractState {

    /**
     * Contains operatins specific to this state
     * 
     * @author - Rohit Mahendra Dhuri
     */

    /**
     * This function accepts or rejects an add request
     * 
     * @param - A string containing the video name, an interger for length,
     *          ChannelConetxt object and results object
     */
    @Override
    public void adRequest(String vName, Integer length, ChannelContext c, Results result) {
        if (length >= 1 && length <= 20) {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::APPROVED" + "\n");
        } else {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::REJECTED" + "\n");
        }
    }
}