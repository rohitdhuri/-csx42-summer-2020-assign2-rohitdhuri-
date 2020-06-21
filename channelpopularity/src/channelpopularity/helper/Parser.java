package channelpopularity.helper;
import channelpopularity.util.FileProcessor;
import channelpopularity.context.ContextI;
import channelpopularity.operation.Operation;
import channelpopularity.context.ChannelContext;
import java.io.IOException;
import channelpopularity.state.StateI;
import java.util.Map;
import java.util.HashMap;

public class Parser {

    FileProcessor fp;
    StateI c;

    public Parser(FileProcessor inFp, StateI inC) {

        fp = inFp;
        c = inC;
    }

    /**
     * parses through the entire input file line by line
     *
     */

    public void process() throws IOException {

        String str = fp.poll();
        String values, vName, operation;
        Map<String, Integer> metricsValues = new HashMap<String, Integer>();


        while (str != null) {
            String[] tokens = str.split("::");
            System.out.println(tokens[0] + " value is " + tokens[1]);

            if (tokens[0].contains("__")) {
                operation = tokens[0].split("__")[0];
                vName = tokens[0].split("__")[1];

            } else {
                operation = tokens[0];
                vName = tokens[1];
            }

            if (operation.equals(Operation.ADD_VIDEO.getConstantValue())) {
                c.addVideo(tokens[1]);
            }

            else if (operation.equals(Operation.REMOVE_VIDEO.getConstantValue())) {
                c.removeVideo(tokens[1]);
            }

            else if (operation.equals(Operation.METRICS.getConstantValue())) {
                values = tokens[1].substring(1, tokens[1].length() - 1);
                String[] metricString = values.split(",");
                for (String p : metricString) {
                    String[] pairs = p.split("=");
                    metricsValues.put(pairs[0], Integer.parseInt(pairs[1]));
                }

                c.metrics(vName, metricsValues.get("VIEWS"), metricsValues.get("LIKES"), metricsValues.get("DISLIKES"));
                System.out.println("Here");
            }

            str = fp.poll();

        }

    }

}
