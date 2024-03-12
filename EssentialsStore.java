// Save the file as "EssentialsStore.java"

//----------------------Structure of EssentialStore.java--------------------------
/**
* Program should receive the cost of items 
* Program should receive the ammount paid 
* Calculate the balance- Difference between ammount and cost items 
* Check if person is eligible to change : wether amount is greater than cost :

	
	• if the ammount paid is less than total cost :
		* Compute the change 
		* Ask the user to top up the positive amount 
		*Inform the user on number of notes and coins they are to top up based on the ammount.
	• If greater than the total cost 
		* Do cost break down of user balance 
	• Inform the user on number of notes and coins they are to receive based on the ammount 
*Program should display a suitable message for the change that the user enters


*/

//------------------Program Implementation-----------------------------//

import java.util.Scanner;


public class EssentialsStore{

	public static void main(String[] args){

Scanner input = new Scanner(System.in);

// Title of program : and user briefing :
System.out.println("Welcome to the change calculator! Enter the cost of items and and the ammount paid as 'positive numbers' to get your change break down");
//Receive cost and ammount paid from the user
System.out.println("Enter cost of items ");

double costOfItems = input.nextDouble();

System.out.println("Enter ammount paid for items ");

double amountPaid = input.nextDouble();



// Invocation of method to compute change 
computeChangeBreakdown(costOfItems,amountPaid);

System.out.println("Note '-' change breakdown values  means the buyer is to top up by that ammount");



}


// Stub for changeSimplification calculation: Calculate the balance into cedis and 
public static int ammountOfNotes(double balance){

	int notesPartOfBalance = (int) balance ;
	return notesPartOfBalance;

}

// This methods returns the numbern of coins for any ammount passed in 2decimal places
public static int ammounOfCoins(double balance){

	int notesPartOfBalance = (int) balance;
	
	int coinsPartOfBalance = (int) ((balance - notesPartOfBalance)*100);
	return coinsPartOfBalance;

}

public static void computeChangeBreakdown(double costOfItmes, double ammountPaid){
//  change from the items bought is balannce
	double balance = ammountPaid - costOfItmes ;
	// covert balance into pesewas
	double formatbalance = Double.parseDouble(String.format("%.2f",balance));
// range of money in shop; Notes : 20, 10, 5, 1. Coins : 50, 10 
int cediNotes = ammountOfNotes(formatbalance);
int cediCoins = ammounOfCoins(formatbalance);

// how many 20 cedis are in the change :
int number_20cedis = cediNotes/ 20 ;
int remainder1 = cediNotes % 20 ;

// how many 10 cedis are in the change :

int number_10cedis = remainder1 / 10;
int remainder2 = remainder1 % 10 ;

// how many 5 cedis are in change 

int number_5cedis = remainder2 / 5;
int remainder3 = remainder2 % 5;

// int how many 1 cedis are in change :
int number_1cedis = remainder3 / 1 ;
int reminder4 = remainder3 / 1;

// How many 5O pesewas are in change 

int number_50peswas = cediCoins/ 50 ;
int remainder5 = cediCoins % 50 ;

// How many 10 pesewas are in change 
int number_10peswas = remainder5/ 10 ;
int remainder6 = remainder5 % 10 ;


// Output for the number of notes and number of coins
int[] number_notes = {number_20cedis,number_10cedis,number_5cedis,number_1cedis};
String[] notes = {"20","10","5","1"};

System.out.println("Here is your change breakdown. You will receive :");
for(int i = 0 ; i< notes.length; i++){
// Check for the available notes and print them out 
if(number_notes[i] != 0){
	
	System.out.printf(" %d %c%s notes",number_notes[i],(char)(162),notes[i]);

}


}
// Output for the number of coins 
String[] coins = {"50","10"};

int[] number_coins = {number_50peswas,number_10peswas};

System.out.println(" Here is your coins breakdown:");
for(int i = 0 ; i< coins.length; i++){

if(number_coins[i] != 0){

	System.out.printf(" %d %s peswas",number_coins[i],coins[i]);

}


}



}
}