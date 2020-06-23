package channelpopularity.helper;

import channelpopularity.util.FileProcessor;
import channelpopularity.util.exception.EmptyFileException;
import channelpopularity.util.exception.InvalidInputFormat;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;
import channelpopularity.context.ContextI;
import channelpopularity.operation.Operation;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Parser {

    FileProcessor fp;
    ContextI c;

    public Parser(FileProcessor inFp, ContextI inC) {

        fp = inFp;
        c = inC;
    }

    /**
     * parses through the entire input file line by line
     * 
     * @throws InvalidInputFormat
     *
     */

    public void process() throws IOException, NegativeLikesOrDislikes, NegativeValueOfViews, VideoAlreadyExists,
            VideoNotFound, EmptyFileException, InvalidInputFormat, NumberFormatException {

        String str = fp.poll();
        if (str == null) {
            throw new EmptyFileException("Input file is empty");
        }

        String values, vName, operation;
        Map<String, Integer> metricsValues = new HashMap<String, Integer>();

        while (str != null) {
            String[] tokens = str.split("::");

            if (tokens[0].equals("") || tokens[1].equals("")) {
                throw new InvalidInputFormat("Line in the input file does not follow the specified formats");
            }
            if (tokens[0].contains("__")) {
                operation = tokens[0].split("__")[0];
                vName = tokens[0].split("__")[1];
            } else {
                operation = tokens[0];
                vName = tokens[1];
            }

            if (operation.equals("") || vName.equals("")) {
                throw new InvalidInputFormat("Line in the input file does not follow the specified formats");
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
            }

            else if (operation.equals(Operation.AD_REQUEST.getConstantValue())) {
                String[] pairs = tokens[1].split("=");
                c.adRequest(vName, Integer.parseInt(pairs[1]));
            }

            else {
                throw new InvalidInputFormat("Line in the input file does not follow the specified formats");
            }

            str = fp.poll();
        }
    }
}
