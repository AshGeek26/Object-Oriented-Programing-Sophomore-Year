/** 
*Guidelines  : Program should contain method called "computeInvestementValue", that takes in parameters " initial ammount to invest(principal),the yearly rate(rate),the number of times the interest is compounded each year(periodsPerYear), and the total value of the investment: "totalPeriods"
*Method should return total value of investment 


*/

/**
*------------------------Computing Tresury Bill Yields ---------------------------**

* Code outline :
 --> Receives input from the user: 
		InitialPrincipal(the ammount to be invested)
		Yearly rate of investment 
		Number of times the interest is compounded each year - 6months(1/2yr 0r ), 3 months(1/4 year or 91 days) and full year

		Total number of periods that the the investment is supposed to last

* Program invokes the computeInvestmentValue: which returns the "total value" of investment
* And the total interest made through out the period of investment 
* Display a nice message infoming on outcome 
		 
		





 */
//--------------------------Program Implementation ---------------------------------


import java.util.Scanner;

public class ComputeTresuryBill{

	//main entry point of program
	public static void main(String[] args){

	
	Scanner input = new Scanner(System.in);
	System.out.println("Welcome to the investment Value calculator, Enter the Required details subsequently to compute your investment at a go");

	System.out.println("Please Enter your intial investment capital ");

	double initialCapital = input.nextDouble();

	System.out.println("Please enter yearly investment percentage ");
	
	double yearlyRate = input.nextDouble();

		System.out.println("After how many months should the interest compoound : 12 months = 1, 6 months = 2, 3 months = 4")	;

	int periodsPerYear = input.nextInt();

		System.out.println("Extra Investment after first period ");

	double extraPrincipal = input.nextDouble();

		System.out.println("Enter total number of periods of investment");
	
	int totalPeriods = input.nextInt();



// invocation of computeInvestmentValue 

double value = computeInvestmentValue(initialCapital,yearlyRate,periodsPerYear,extraPrincipal,totalPeriods);
double interest = value - (initialCapital + (totalPeriods-1)*extraPrincipal );
System.out.printf("Your total ammount from investment is %c%.2f and your interest is %c%.2f",(char)162,value,(char)162,interest);
//01074	572	0x23C	&#572;
input.close();

}

public static double computeInvestmentValue(double principal, double yearlyRate, int periodsPerYear,double extraCapital, int totalPeriods){

double ammount = 0;

double interest = 0.00;
double periodicRate = (yearlyRate / 100.0) / (double) periodsPerYear;


for (int i= 0; i < totalPeriods; i++){

	// Calculate interest and ammount beyond first period
	//
	if (i == 0 ){
		interest = principal * (periodicRate);
		ammount = principal + interest;
		

}else{
	ammount = ammount + extraCapital;
	interest = ammount * (periodicRate);
	ammount+= interest;

}

}	
return ammount;
}


















}

