package channelpopularity.util.exception;

public class VideoAlreadyExists extends Exception {

    /**
     * VideoAlreadyExists class
     * 
     * @author Rohit Mahendra Dhuri
     * 
     */

    /**
     * VideoAlreadyExists constructor calling the parent class object
     * 
     * @param s - The error message
     */

    public VideoAlreadyExists(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Class: VideoAlreadyExists, Data Members: [ ]";
    }

}
