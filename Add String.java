import java.util.* ;
import java.io.*; 

public class Solution {

	public static String stringConcatenation(String num1, String num2) {
		// Write your code here.
		// Initialize a StringBuilder to store the result
		StringBuilder result = new StringBuilder();
		
		// Initialize carry to 0
		int carry = 0;
		
		// Get the lengths of both strings
		int len1 = num1.length();
		int len2 = num2.length();
		
		// Loop through the strings from right to left
		for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
			// Get the digits from the strings (or 0 if the index is out of bounds)
			int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
			int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
			
			// Calculate the sum of the digits and the carry
			int sum = digit1 + digit2 + carry;
			
			// Add the least significant digit of the sum to the result
			result.insert(0, sum % 10);
			
			// Update the carry for the next iteration
			carry = sum / 10;
		}
		
		// Convert the StringBuilder to a String and return it
		return result.toString();
	}
}
