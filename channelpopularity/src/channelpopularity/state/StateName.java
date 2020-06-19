package channelpopularity.state;

public enum StateName {

    UNPOPULAR("UNPOPULAR"),
    MILDLY_POPULAR("MILDLY_POPULAR"),
    HIGHLY_POPULAR("HIGHLY_POPULAR"),
    ULTRA_POPULAR("ULTRA_POPULAR");

    private final String stStr;

    StateName(String st){
        stStr = st;
    }

    public String getConstantValue(){
        return stStr;
    }
}
