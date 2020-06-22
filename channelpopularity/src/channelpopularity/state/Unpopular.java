package channelpopularity.state;

import channelpopularity.context.ChannelContext;

public class Unpopular extends AbstractState {

    @Override
    public void adRequest(String vName, Integer length,ChannelContext c) {
        if(length >= 1 && length <= 10){
            System.out.println(c.getCurrentState()+"__AD_REQUEST::APPROVED");
        } else{
            System.out.println(c.getCurrentState()+"__AD_REQUEST::REJECTED");
        }
    }

/*        
        if (pScore >= 1000 && pScore <= 10000) {
            channelCObj.setCurrentState(StateName.MILDLY_POPULAR);
        } else if (pScore >= 10001 && pScore <= 100000) {
            channelCObj.setCurrentState(StateName.HIGHLY_POPULAR);
        } else if (pScore >= 100001 && pScore <= Integer.MAX_VALUE) {
            channelCObj.setCurrentState(StateName.ULTRA_POPULAR);
        }else{}

        */
    }
