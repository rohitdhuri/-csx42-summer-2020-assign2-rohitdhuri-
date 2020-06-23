package channelpopularity.state.factory;
import channelpopularity.state.StateName;
import channelpopularity.state.Unpopular;
import channelpopularity.state.MildlyPopular;
import channelpopularity.state.HighlyPopular;
import channelpopularity.state.UltraPopular;
import channelpopularity.state.StateI;


public class SimpleStateFactory implements SimpleStateFactoryI {


    public StateI create(StateName state){
        switch (state) {
            case UNPOPULAR:
            return new Unpopular();

            case MILDLY_POPULAR:
            return new MildlyPopular();

            case HIGHLY_POPULAR:
            return new HighlyPopular();

            case ULTRA_POPULAR:
            return new UltraPopular();

            default: 
            return null;
        }

    }
}
