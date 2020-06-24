package channelpopularity.operation;

public enum Operation {

    ADD_VIDEO("ADD_VIDEO"), REMOVE_VIDEO("REMOVE_VIDEO"), METRICS("METRICS"), AD_REQUEST("AD_REQUEST");

    private final String opStr;

    /**
     * enum constructor 
     * 
     * @param - String value of enum
     */
    Operation(String op) {
        opStr = op;
    }

    /**
     * returns the value of enum
     */
    public String getConstantValue() {
        return opStr;
    }

}
