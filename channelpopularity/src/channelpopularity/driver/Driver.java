package channelpopularity.driver;
import channelpopularity.util.FileProcessor;
import channelpopularity.helper.Parser;
import channelpopularity.state.factory.SimpleStateFactory;
import channelpopularity.state.factory.SimpleStateFactoryI;


/**
 * @author Rohit Mahendra Dhuri
 *
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 2) || (args[0].equals("${input}")) || (args[1].equals("${output}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");


		FileProcessor fp = new FileProcessor(args[0]);

		//SimpleStateFactoryI ssf = new SimpleStateFactory();




		Parser p = new Parser(fp);
		p.process();




	}
}
