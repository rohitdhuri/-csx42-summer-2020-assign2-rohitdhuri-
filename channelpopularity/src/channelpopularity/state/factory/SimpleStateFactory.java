package channelpopularity.state.factory;
import channelpopularity.state.StateName;
import channelpopularity.state.Unpopular;
import channelpopularity.state.MildlyPopular;
import channelpopularity.state.HighlyPopular;
import channelpopularity.state.UltraPopular;



public class SimpleStateFactory implements SimpleStateFactoryI {


    public StateI create(StateName state){
        StateI state = null;
        switch (state) {
            case UNPOPULAR:
            state = new Unpopular();
            return state;

            case MILDLY_POPULAR:
            state = new MildlyPopular();
            return state;

            case HIGHLY_POPULAR:
            state = new HighlyPopular();
            return state;

            case ULTRA_POPULAR:
            state = new UltraPopular();
            return state;

            default: 
            return state;
        }

    }
}
