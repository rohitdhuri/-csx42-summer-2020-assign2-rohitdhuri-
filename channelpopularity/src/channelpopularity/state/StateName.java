package channelpopularity.state;

public enum StateName {

    UNPOPULAR("UNPOPULAR"), MILDLY_POPULAR("MILDLY_POPULAR"), HIGHLY_POPULAR("HIGHLY_POPULAR"),
    ULTRA_POPULAR("ULTRA_POPULAR");

    private final String stStr;

    /**
     * StateName constructor used for creating constant
     * 
     * @param - String value
     */
    StateName(String st) {
        stStr = st;
    }

    /**
     * This function returns the constatnt value of an enum
     * 
     */
    public String getConstantValue() {
        return stStr;
    }
}
