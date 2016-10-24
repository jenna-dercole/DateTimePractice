
package student.lab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenna
 */
public class DateUtilities {
    private String date;
    //At least four methods: get current date, get date differences, validate these methods,
    //Test, name things well, document, and distribute.
    
   /**
    * This method returns the current date formatted as: "MM-dd-yyyy hh:mm:ss a".
    * 
    * @return the current date formatted as a string
    */
    public final String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(formatter);
    }
    
    /**
     * This method takes a user-input date, validates it with a helper method, and outputs a LocalDate object
     * constructed from the user-input string.
     * 
     * @return a LocalDate object parsed from user-entered string input.
     * @throws IndexOutOfBoundsException
     */

    public final LocalDate convertStringToDate() throws IndexOutOfBoundsException {
    //get string input from user, parse it to an array, loop through array to validate for:
    //-no negative values, no alphanumeric characters, each value is within an acceptable range:
    //()
    LocalDate parsedDate = null;
    String[] splitDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String date = JOptionPane.showInputDialog("Please enter a date in MM-dd-yyyy format: ");

    try {
        DateUtilities.validateDateInput(date);
    } catch (IllegalArgumentException iae) {
        JOptionPane.showMessageDialog(null, iae.getMessage());
    }

    splitDate = date.split("-"); 

    if (Integer.parseInt(splitDate[0]) < 0 || Integer.parseInt(splitDate[0]) > 12) {
        throw new IndexOutOfBoundsException("Please enter a valid month!");
    } else if (Integer.parseInt(splitDate[1]) < 0 || Integer.parseInt(splitDate[1]) > 31) {
        throw new IndexOutOfBoundsException("Days can't be less than 1 or greater than 31!");
    } else if (Integer.parseInt(splitDate[2]) < 1600 || Integer.parseInt(splitDate[2]) > 2099) {
        throw new IndexOutOfBoundsException("Please enter a valid year!");
    } else {
        parsedDate = LocalDate.parse(date, formatter);   
    }

    return parsedDate;

}
   
//        public static void main(String[] args) {
//        try {
//        System.out.println(convertStringToDate());
//        } catch (IndexOutOfBoundsException iobe){
//         JOptionPane.showMessageDialog(null, iobe.getMessage());
//        }
//    }
        
    public static final void validateDateInput(String date) throws IllegalArgumentException {
        boolean isValid;
         if (date == null || date.length() == 0) {
            throw new IllegalArgumentException("Please enter a value!");
        } else if (date.indexOf("-") == -1){
            throw new IllegalArgumentException("Please provide a date in the specified format!");
        } else if (date.contains("[A-Za-z]")) {
            throw new IllegalArgumentException("Please do not enter letters for a date!");
        } else {
            isValid = true;
        }
    }
    
//    public final LocalDateTime getDateDifference() {
//        String date1 = JOptionPane.showInputDialog("Please enter a date in the mm/dd/yyyy format: ");
//        String date2 = JOptionPane.showInputDialog("Please enter a date in the mm/dd/yyyy format: ");
//        
//    }
    
    
}
