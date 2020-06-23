package channelpopularity.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Results class - Implements the methods in StdoutDisplayInterface and
 * FileDsiplayInterface to print the output on console and in the file
 * respectively.
 * 
 * @author - Rohit Mahendra Dhuri
 * 
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String output;
    private String filePath;

    /**
     * constructor has the file path as its parameter, which it stores into a local
     * variable
     */

    public Results(String path) {
        output = "";
        filePath = path;
    }

    /**
     * storeOutput method stores the output buffer into the local variable
     */

    public void storeOutput(String buffer) {
        output += buffer;
    }

    /**
     * storeMetrics method stores the metrics calculated into the local variable
     */

    /**
     * Implemented writeToStdout method writes to the console
     */

    public void writeToStdout() {
        System.out.println(output);
    }

    /**
     * Implemented writeToFile method writes to the file
     */

    public void writeToFile() throws IOException {

        FileWriter outputFile = new FileWriter(filePath);
        outputFile.write(output);
        outputFile.close();
        System.out.println("Successfully wrote to file.");
    }

    @Override
    public String toString() {
        return "output= " + output + " filePath= " + filePath;
    }

}