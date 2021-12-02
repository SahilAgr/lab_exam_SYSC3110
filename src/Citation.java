/**
 * Author: Sahil Agrawal
 * Description: The methods that make the citations
 * Version: 1.0
 */
public class Citation {

    /**
     * Returns the formatted String for the IEEE citation
     * @param firstName String of the first name
     * @param lastName String of the last Name
     * @return String of the formateed answer
     */
    public String IEEE (String firstName, String lastName){
        String sub = lastName.substring(0,1);
        return sub+". "+firstName;
    }

    /**
     * Returns the formatted String for the ACM citation
     * @param firstName String of the first name
     * @param lastName String of the last Name
     * @return String of the formateed answer
     */
    public String ACM(String firstName, String lastName){
        return firstName+" "+lastName+".";
    }


}
