import java.util.* ;
import java.io.*; 
public class Solution{
	public static String convertString(String str) {
            // Write your code here
            String[] words = str.split(" ");
        
        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Loop through each word in the array
        for (String word : words) {
            // Get the first character of the word and convert it to uppercase
            char firstChar = Character.toUpperCase(word.charAt(0));
            
            // Append the uppercase first character and the rest of the word to the result
            result.append(firstChar).append(word.substring(1)).append(" ");
        }
        // Convert the StringBuilder to a String and return it
        return result.toString().trim();
    }
}
