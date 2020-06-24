package channelpopularity.driver;

import channelpopularity.util.FileDisplayInterface;
import channelpopularity.util.FileProcessor;
import channelpopularity.util.StdoutDisplayInterface;
import channelpopularity.util.exception.EmptyFileException;
import channelpopularity.util.exception.InvalidInputFormat;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;
import channelpopularity.util.Results;
import channelpopularity.state.factory.SimpleStateFactory;
import channelpopularity.state.factory.SimpleStateFactoryI;
import channelpopularity.state.StateName;
import channelpopularity.context.ChannelContext;
import channelpopularity.context.ContextI;
import channelpopularity.helper.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Arrays;

/**
 * @author Rohit Mahendra Dhuri
 *
 */

public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case
		 * the argument value is not given java takes the default value specified in
		 * build.xml.
		 */
		if ((args.length != 2) || (args[0].equals("${input}")) || (args[1].equals("${output}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}

		try {

			/**
			 * input file path is passed to the FileProcessor while instantiation
			 *
			 */
			FileProcessor fp = new FileProcessor(args[0]);

			/**
			 * SimpleStateFactory object is instatntiated
			 * 
			 */
			SimpleStateFactoryI ssf = new SimpleStateFactory();

			/**
			 * Output filepath is passed to the results as argument while instatiation
			 *
			 */
			Results result = new Results(args[1]);

			/**
			 * The satefactory object, result object and a list of statenames is given as
			 * arguments
			 *
			 */
			ContextI c = new ChannelContext(ssf, Arrays.asList(StateName.values()), result);

			/**
			 * Parser object is instatiated by passing its constructor the fileprocessor and
			 * context objects
			 *
			 */
			Parser p = new Parser(fp, c);
			p.process();

			StdoutDisplayInterface stdi = result;
			FileDisplayInterface fdi = result;

			stdi.writeToStdout();
			fdi.writeToFile();

		} catch (NegativeLikesOrDislikes | NegativeValueOfViews | VideoAlreadyExists | VideoNotFound
				| EmptyFileException | InvalidInputFormat | NumberFormatException | InvalidPathException
				| SecurityException | IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
