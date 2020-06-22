package channelpopularity.state;

import channelpopularity.util.data.VideoData;
import channelpopularity.context.ChannelContext;
import channelpopularity.context.ContextI;
import channelpopularity.util.Results;

public class HighlyPopular extends AbstractState{


    @Override
    public void adRequest(String vName, Integer length,ChannelContext c, Results result) {
        if(length >= 1 && length <= 30){
            result.storeOutput(c.getCurrentState()+"__AD_REQUEST::APPROVED"+"\n");
        } else{
            result.storeOutput(c.getCurrentState()+"__AD_REQUEST::REJECTED"+"\n");
        }
    }

/*
        if (pScore >= 0 && pScore <= 1000) {
            channelCObj.setCurrentState(StateName.UNPOPULAR);
        } else if (pScore >= 1000 && pScore <= 10000) {
            channelCObj.setCurrentState(StateName.MILDLY_POPULAR);
        } else if (pScore >= 100001 && pScore <= Integer.MAX_VALUE) {
            channelCObj.setCurrentState(StateName.ULTRA_POPULAR);
        }else{}*/

    }
