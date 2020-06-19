package channelpopularity.helper;
import channelpopularity.util.FileProcessor;
import java.io.IOException;

public class Parser{

    FileProcessor fp;

    public Parser(FileProcessor inFp){

        fp = inFp;
    }

/**
 * parses through the entire input file line by line
 *
 */

    public void process() throws IOException
    {

		String str = fp.poll();
		while(str!= null){			
			String[] tokens = str.split("::");		
			System.out.println(tokens[0] + " value is " + tokens[1]);
			

			str= fp.poll();
		} 

    }

}