package channelpopularity.util.exception;

public class NegativeValueOfViews extends Exception {
    
    /**
     * NegativeValueOfViews class
     * 
     * @author Rohit Mahendra Dhuri
     * 
     */    

        /**
         * NegativeValueOfViews constructor calling the parent class
         * object
         * 
         * @param s - The error message
         */

        public NegativeValueOfViews(String s){
            super(s);
        }


        @Override
        public String toString() {
            return "Class: NegativeValueOfViews, Data Members: [ ]";
        }


}