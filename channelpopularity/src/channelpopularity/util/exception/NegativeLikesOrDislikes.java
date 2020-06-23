package channelpopularity.util.exception;

public class NegativeLikesOrDislikes extends Exception {
    
    /**
     * NegativeLikesOrDislikes class
     * 
     * @author Rohit Mahendra Dhuri
     * 
     */    

        /**
         * NegativeLikesOrDislikes constructor calling the parent class
         * object
         * 
         * @param s - The error message
         */

        public NegativeLikesOrDislikes(String s){
            super(s);
        }


        @Override
        public String toString() {
            return "Class: NegativeLikesOrDislikes, Data Members: [ ]";
        }


}