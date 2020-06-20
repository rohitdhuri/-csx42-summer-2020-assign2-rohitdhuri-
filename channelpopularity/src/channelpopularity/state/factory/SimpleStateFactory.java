package channelpopularity.state.factory;
import channelpopularity.state.StateName;
import channelpopularity.state.Unpopular;
import channelpopularity.util.data.VideoData;
import channelpopularity.state.MildlyPopular;
import channelpopularity.state.HighlyPopular;
import channelpopularity.state.UltraPopular;
import channelpopularity.state.StateI;
import channelpopularity.context.ContextI;


public class SimpleStateFactory implements SimpleStateFactoryI {


    public StateI create(StateName state, ContextI channelCObj, VideoData vd){
        switch (state) {
            case UNPOPULAR:
            return new Unpopular(channelCObj, vd);

            case MILDLY_POPULAR:
            return new MildlyPopular(channelCObj, vd);

            case HIGHLY_POPULAR:
            return new HighlyPopular(channelCObj, vd);

            case ULTRA_POPULAR:
            return new UltraPopular(channelCObj, vd);

            default: 
            return null;
        }

    }
}
