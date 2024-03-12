/**
*Random Passowrd Generator
*Program should receive input: minimum password length,minimum number of uppercase letter,minimum number of digits, munumum num of special characters, string of allowed special characters

*
*This program receives the input from the user for the specifications of a password and creates that password for them

*/

//------------------Code to generate randome passwords--------------------------

/**
Code structure
Static method called generatePassword that takes in parameters: minPasswordLength, minUpperCase, minNumberOfDigits,minNumberOfSpecialCharacters, specialCharacters 


*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class GeneratingRandomPasswords{

	

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
	
			System.out.println("Enter the minimum password length: ");
			int minPasswordLength = input.nextInt();
	
			System.out.println("Enter the minimum number of uppercase letters: ");
			int minUpperCase = input.nextInt();
	
			System.out.println("Enter the minimum number of digits it should contain: ");
			int minNumberOfDigits = input.nextInt();
	
			System.out.println("Enter the minimum number of special characters: ");
			int minSpecialCharacters = input.nextInt();
	
			String pwrd = generatePassword(minPasswordLength, minUpperCase, minNumberOfDigits, minSpecialCharacters);
			System.out.println("Generated Password: " + pwrd);
	
			input.close(); // Close the Scanner

			

		}
//Stub to check password 
/**
 * Take the returned random password ; check lenght 
 * Take the returned random password; and run it through a for each loop ; 
 * as it does that check and sort the characters of the password into arrays
 * check the lengths of the arrays and if the don't meet the minimum lenght required you declare the password invalid.
 * @param array
 * @return
 */
// METHOD TO CONVERT OBJECTS OF ALL DATA TYPES TO LIST 
public static List<Character> toList(char[] array) {
	List<Character> list = new ArrayList<>();
	for (char c : array) {
		list.add(c);
	}
	return list;
}
public static List<Integer> toList(int[] array) {
    List<Integer> list = new ArrayList<>();
    for (int num : array) {
        list.add(num);
    }
    return list;
}

// Stub for generatePassword
public static String generatePassword(int minPasswordLength, int minUpperCase, int minNumberOfDigits, int minSpecialCharacters){
	// This generates list of random upperCase letters for the password
	char[] passwordUpperCase =  UpperCaseGen(minUpperCase);
	int[] passwordDigits = randomInt(minNumberOfDigits);
	ArrayList<String> passwordSpecialChar = specialCharacters(minSpecialCharacters);

	
	// Combine the upperCase letters with the digits

	List<Character> upperCaseList = toList(passwordUpperCase);
        List<Integer> digitsList = toList(passwordDigits);
		List<String> specialCharList = passwordSpecialChar;

        // Combine uppercase letters and digits into a single list
		// Got help from an online source on how to combine the list of different kind of values into a similar usable object :
		// Source : https://www.baeldung.com/java-combine-collections#:~:text=List%20combined%20%3D%20new,across%20all%20Lists%20and%20Sets.
        List<Object> combinedList = new ArrayList<>();
        combinedList.addAll(upperCaseList);
        combinedList.addAll(digitsList);
		combinedList.addAll(specialCharList);
// to test if it prints
		// List<Object> charArray = combinedList;
		// for (char ch : charArray) {
		// 	System.out.println(ch);
		// Now I will randomly select some characters,digits and uppercase letters based on a random indexless than the length of the password
		// Got help with string builder usage from w3 Schools
		StringBuilder password = new StringBuilder();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Keep generating password until the minimum length is reached
        while (password.length() < minPasswordLength) {

            int randomIndex = random.nextInt(combinedList.size());
            Object character = combinedList.get(randomIndex);
            password.append(character);

            // Check if the minimum password length is reached
            if (password.length() >= minPasswordLength) {
                System.out.println("Minimum password length reached.");
                System.out.print("Enter 'done' to finish, or press Enter to continue: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
            }
        }
        return password.toString();
		}


		
    

		


// Generates random upperCase letters
public static char[] UpperCaseGen(int minUpperCase){
Random random = new Random();
char [] randomUpperCase = new char[minUpperCase];
for(int i = 0 ; i < minUpperCase; i++){
int asciiValue = random.nextInt(26)+ 65; // range of ascii values for upper case letters starting from A to z

char randomChar = (char)asciiValue;
randomUpperCase[i] = randomChar;

}
return randomUpperCase;


}
// function to generate a list of  random numbers
public static int[] randomInt(int minNumberOfDigits){
	Random random = new Random();
	int [] randomDigit = new int[minNumberOfDigits];
	for(int i = 0 ; i < minNumberOfDigits; i++){
	int randomValue = random.nextInt(10) ; // Generates number from 0 to 10(to exclusive)
	
	randomDigit[i] = randomValue;
	
	}
	return randomDigit;
	
	
	}

	public static ArrayList<String> specialCharacters(int minSpecialCharacters) {
		ArrayList<String> characters = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String entry;
		boolean done = false;

		// Collecting special characters until the user meets the minimum requirement
		int i = 0;
		while (!done && i < minSpecialCharacters) {
			System.out.println("Please enter some special characters: ");
			entry = input.next();
			characters.add(entry);
			i++;

			// Check if the user is done entering characters
			if (entry.equals("done")) {
				done = true;
			}
		}

		// Close the scanner
		input.close();

		// Return the ArrayList of characters
		return characters;
	}







}