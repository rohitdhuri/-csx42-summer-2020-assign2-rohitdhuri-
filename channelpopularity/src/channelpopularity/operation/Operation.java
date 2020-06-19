package channelpopularity.operation;

public enum Operation {

    ADD_VIDEO("ADD_VIDEO"),
    REMOVE_VIDEO("REMOVE_VIDEO"),
    METRICS("METRICS"),
    AD_REQUEST("AD_REQUEST");

    private final String opStr;

    Operation(String op){
        opStr = op;
    }

    public String getConstantValue(){
        return opStr;
    }

}
