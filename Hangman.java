
/**
*----OBJECT ORIENTED PROGRAMMING LAB ASSIGNMENT 3----------------
*Author = Samuel Digilituo Yussif 
*Student ID = 46712026
Refrence : Figured it out alone and checked api documentation and Other Google searches

Problem 1: Hangman Game
*/



import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args){


	// Guide User on How to play Game
	// Program Header: 

		System.out.println("Heyy!! Welcome to the Hangman Game!");
		System.out.println("Here is how it works : ");
		System.out.println("A random word you don't know is generated");
		System.out.println("You  are asked to guess the 'LOWER CASE' letters that make up the word at every go");
		System.out.println("Once you get a letter right the random word is displayed to you with the letters you have guessed only visible");
		System.out.println("When you successfully guess the word at the end of the game you can choose to continue or end");
		System.out.println("Hope you enjoy the game!! It's exciting");
		System.out.print("\n");

		int count = 0;
		String word;
		String[] words = {"boyson","giving","car"};// Array containing simple words for a start

		if(args.length == 0){
			word = getRandomWord(words);
			
		}else{
	
			word = getRandomWord(args);
		}


		String wordTobeGuessed = "*".repeat(word.length());
	
	// main execution point of the program
	mainGameLoop(wordTobeGuessed,word,words,count);



		}

	
	/**
	 * This is the main game loop where most of the activities of the game take place in 
	 * @param wordTobeGuessed
	 * @param word
	 * @param words
	 */
	public static void mainGameLoop( String wordTobeGuessed,String word,String[] words,int count){
	// take the wordtoBeGuessed(Asterisk version) and the random word 
	// ask the user to enter a letter 
	
	
		while(wordTobeGuessed.contains("*")){
			String guessedLetter = GuessLetter(wordTobeGuessed);
			 
			
			replaceLetter(word, wordTobeGuessed, guessedLetter, words,count);
			
	}
	
		System.out.println("The word is " + wordTobeGuessed + ".You missed " + displayCount(count) );// if the whole word is guessed print what the word is and ask the user to exit or stay
		// find out if the user want to continue and then do as such 
		String answer = promptToContinueGame();
		if(repeatGame(answer) == true){
			String newWWord = getRandomWord(words);
			String newwordTobeGuessed = "*".repeat(word.length());
			mainGameLoop(newwordTobeGuessed, newWWord, words,count);
		}else{
			System.exit(0);
		}
	
	
	}

	public static String promptToContinueGame(){
		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to guess another word? Enter y or n> ");
		String answer = input.next();
		System.out.println();
		return answer;
	}


	/**
	 *  GuessLetter method prompts the user to enter a letter and returns that letter for replacement
	 * @param wordTobeGuessed
	 * @return retuns the letter the user guesses
	 */
	public static String GuessLetter(String wordTobeGuessed){
	/** Ask the user to guess the word */
	// Prompt the user 
		Scanner input = new Scanner(System.in);

		System.out.print("(Guess) Enter a letter in word " + wordTobeGuessed + " > ");

		String guessedLetter = input.next();

		System.out.println();
		//input.close();
		return guessedLetter;

			}
	/**
	 * replaceLetter replaces all occurences of the guessed letter in the word to be guessed
	 * @param word
	 * @param wordTobeGuessed
	 * @param guessedLetter
	 * @param letterIndex
	 * @return returns the wordTobeGuessed(in it's updated form)
	 */
	public static void replaceLetter(String word, String wordTobeGuessed,String guessedLetter,String[] words,int count){
		// find the index of the letter the user guessed
		
			int letterIndex = word.indexOf(guessedLetter);
		if( word.contains(guessedLetter) && wordTobeGuessed.charAt(letterIndex) == '*'){
			while(letterIndex != -1){
				wordTobeGuessed = wordTobeGuessed.substring(0,letterIndex)+ guessedLetter + wordTobeGuessed.substring(letterIndex+1);
				
				letterIndex = word.indexOf(guessedLetter,letterIndex + 1);
			
		}
		
		mainGameLoop(wordTobeGuessed, word,words,count) ;
		}else if(word.contains(guessedLetter) && wordTobeGuessed.charAt(letterIndex) != '*'){
			System.out.printf("%4s  is already in word\n",wordTobeGuessed.charAt(letterIndex));
			count++;
			mainGameLoop(wordTobeGuessed, word,words,count);
		}else{
			System.out.printf("%4s  is not in word\n",guessedLetter);
			count++;
			mainGameLoop(wordTobeGuessed, word,words,count);
		}
		return; 
	}

	/**
	 * This repeat game causes the game to start all over by changing the word to be guessed
	 * @param answer 
	 * @return void 
	 */
	public static boolean repeatGame(String answer){
		
		if(answer.equals("y") ){
			//pick random word and make the word to be guessed version 
			return true;
		}else{
			return false;
		}
	}

	/**
	 * getRandom takes the in an array data type and returns a random word
	 * @param words
	 * @return returns a random word from the array of Strings 
	 */
	public static String getRandomWord(String[] words){

		Random random = new Random();

		int randomIndex = random.nextInt(words.length);

		String word = words[randomIndex];
		return word;
	}


	public static String displayCount(int count){
		if(count > 1){
		
			return count + " times";

		}else{
			return count + " time";
		}
	}
	}















