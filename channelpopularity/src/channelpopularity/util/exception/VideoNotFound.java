package channelpopularity.util.exception;

public class VideoNotFound extends Exception {
    
/**
 * VideoNotFound class
 * 
 * @author Rohit Mahendra Dhuri
 * 
 */    

    /**
     * VideoNotFound constructor calling the parent class
     * object
     * 
     * @param s - The error message
     */

    public VideoNotFound(String s){
        super(s);
    }


    @Override
    public String toString() {
        return "Class: VideoNotFound, Data Members: [ ]";
    }


}