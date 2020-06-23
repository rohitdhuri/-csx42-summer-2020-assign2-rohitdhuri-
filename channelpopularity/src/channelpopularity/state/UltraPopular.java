package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;

public class UltraPopular extends AbstractState {

    @Override
    public void adRequest(String vName, Integer length, ChannelContext c, Results result) {
        if (length >= 1 && length <= 40) {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::APPROVED" + "\n");
        } else {
            result.storeOutput(c.getCurrentState() + "__AD_REQUEST::REJECTED" + "\n");
        }

    }

}
