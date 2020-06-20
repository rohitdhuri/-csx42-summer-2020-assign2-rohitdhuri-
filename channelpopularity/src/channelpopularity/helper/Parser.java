package channelpopularity.helper;

import channelpopularity.util.FileProcessor;
import channelpopularity.context.ContextI;
import channelpopularity.context.ChannelContext;
import java.io.IOException;
import channelpopularity.state.StateI;

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
        while (str != null) {
            String[] tokens = str.split("::");
            System.out.println(tokens[0] + " value is " + tokens[1]);

            switch (tokens[0]) {
                case "ADD_VIDEO":
                    c.addVideo(tokens[1]);
                    break;

                case "REMOVE_VIDEO":
                    c.removeVideo(tokens[1]);
                    break;

                default:
                    break;
            }

            str = fp.poll();
        }

    }

}