/**
*----OBJECT ORIENTED PROGRAMMING LAB ASSIGNMENT 3----------------
*Author = Samuel Digilituo Yussif 
*Student ID = 46712026
Refrence : Figured it out alone and checked api documentation and Other Google searches
Other Reference : Percy FI helped me think through the algorithm 

Problem 2: CountFour Game
*/


import java.util.Scanner;
public class ConnectFour {

    public static void main(String[] args){

    String[][] gameBoard = new String[6][7];

    mainGameLoop(gameBoard);

    }
    /**
     * mainGameLoop is where the entire game runs calling all the neccessary methods
     * @param gameBoard represents the gameBoard the user created
     */

    public static void mainGameLoop(String[][] gameBoard) {
        newGameBoard(gameBoard);
        displayGameBoard(gameBoard);
    
        while (true) {
            player1Turn(gameBoard);
            displayGameBoard(gameBoard);
            if (checkHorizontal(gameBoard)|| checkVertical(gameBoard)|| checkDiagonal(gameBoard)) {
                System.out.println("The red player won");
                return;
            }
    
            player2Turn(gameBoard);
            displayGameBoard(gameBoard);
            if (checkHorizontal(gameBoard)||checkVertical(gameBoard)||checkDiagonal(gameBoard)) {
                System.out.println("The yellow player won");
                return;
            }
        }
    }


    /**
     * checkDiagonal checks for the diagonal matches [top-left to bottom right,
     * top right to bottom left,bottom-left to top-right and from bottom-right to top-left]
     * @param gameBoard refers to the gameboard to be checked
     * @return returns a boolean true when there's diagonal  match and false when no match is found
     */
    public static boolean checkDiagonal(String[][] gameBoard) {
        // Check for matches from top-left to bottom-right
        for (int i = 0; i < gameBoard.length - 3; i++) {
            for (int j = 0; j < gameBoard[i].length - 3; j++) {
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i + 1][j + 1]) &&
                    gameBoard[i][j].equals(gameBoard[i + 2][j + 2]) &&
                    gameBoard[i][j].equals(gameBoard[i + 3][j + 3])) {
                    return true; // Diagonal win detected
                }
            }
        }
    
        // Check for matches from top-right to bottom-left
        for (int i = 0; i < gameBoard.length - 3; i++) {
            for (int j = 3; j < gameBoard[i].length; j++) {
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i + 1][j - 1]) &&
                    gameBoard[i][j].equals(gameBoard[i + 2][j - 2]) &&
                    gameBoard[i][j].equals(gameBoard[i + 3][j - 3])) {
                    return true; // Diagonal win detected
                }
            }
        }
    
        // Check for matches from bottom-left to top-right
        for (int i = 3; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length - 3; j++) {
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i - 1][j + 1]) &&
                    gameBoard[i][j].equals(gameBoard[i - 2][j + 2]) &&
                    gameBoard[i][j].equals(gameBoard[i - 3][j + 3])) {
                    return true; // Diagonal win detected
                }
            }
        }
    
        // Check for matches from bottom-right to top-left
        for (int i = 3; i < gameBoard.length; i++) {
            for (int j = 3; j < gameBoard[i].length; j++) {
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i - 1][j - 1]) &&
                    gameBoard[i][j].equals(gameBoard[i - 2][j - 2]) &&
                    gameBoard[i][j].equals(gameBoard[i - 3][j - 3])) {
                    return true; // Diagonal win detected
                }
            }
        }
    
        return false; // No diagonal win detected
    }

    /**
     * This method checks for any cards that are vertically matching 
     * @param gameBoard refers to the gameboard to be checked
     * @return returns a boolean true when there's vertical  match and false when no match is found
     */

    public static boolean checkVertical(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length - 3; i++) { // Iterate until the third-to-last row
            for (int j = 0; j < gameBoard[i].length; j++) { // Iterate over all columns
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i + 1][j]) &&
                    gameBoard[i][j].equals(gameBoard[i + 2][j]) &&
                    gameBoard[i][j].equals(gameBoard[i + 3][j])) {
                    return true; // Vertical win detected
                }
            }
        }
        return false; // No vertical win detected
    }



    /**
     * CheckHorizontal checks for a horizontal match of the cards in the game
     * @param gameBoard refers to the gameboard to be checked
     * @return returns a boolean true when there's horizontal  match and false when no match is found
     */
    public static boolean checkHorizontal(String[][] gameBoard) {

        //Checks Horizontally for the match 
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length - 3; j++) {
                if (!gameBoard[i][j].equals(" ") &&
                    gameBoard[i][j].equals(gameBoard[i][j + 1]) &&
                    gameBoard[i][j].equals(gameBoard[i][j + 2]) &&
                    gameBoard[i][j].equals(gameBoard[i][j + 3])) {
                    return true; // Horizontal win detected
                }
            }
        }
        return false; // No horizontal win detected
    }

    /**
     * player1Turn combines the prompting of the user and insertion of the card the user entered
     * @param gameBoard represents the orginal gameBoard(6 by 7 board)
     */

        public static void player1Turn(String[][] gameBoard){
            final String diskPlayed = "R";
            int diskLocation = Player1GamePrompt();
            ReplaceCard(diskLocation,gameBoard,diskPlayed);
        }
    /**
     * player2Turn combines the prompting of the user and insertion of the card the user entered
     * @param gameBoard represents the orginal gameBoard(6 by 7 board)
     */
        public static void player2Turn(String[][] gameBoard){
            final String diskPlayed = "Y";
            int diskLocation = Player2GamePrompt();
            ReplaceCard(diskLocation,gameBoard,diskPlayed);
        }


    /**
     * ReplaceCard takes the column the user enters and places the card there 
     * @param cardIndex represents index of the card the user entered 
     * @param gameBoard represents the gameBoard 
     * @param cardPlayed represents the particular card the user played Y or R
     */
    public static void ReplaceCard(int cardIndex, String[][] gameBoard, String cardPlayed){
        int row = 5;
        while(row >= 0){
            if(gameBoard[row][cardIndex] != " "){

                row--;
            }else{
                gameBoard[row][cardIndex] = cardPlayed;
                return;
            }
        }
    }

    /**
     * Player1GamePrompt prompts first user to play game
     * @return returns a string datatype of player1's entry expects 'R'
     */
    public static int  Player1GamePrompt(){
        System.out.print("Drop a red disk at column(0-6): ");
        Scanner input = new Scanner(System.in);
        int  cardEntry = input.nextInt();
        System.out.println();
        
        return cardEntry;
    }
    /**
     * Player2GamePrompt prompts second player to play game
     * @return returns a string datatype of player2's entry expects '   Y'
     */
    public static int Player2GamePrompt(){
        System.out.print("Drop a Yellow disk at column(0-6): ");
        Scanner input = new Scanner(System.in);
        int cardEntry = input.nextInt();
        System.out.println();
    
        return cardEntry;
    }

    /**
     * newGameBoard sets elements in the string type array gameBoard to an empty string 
     * @param gameBoard the original gameBoard with default elements null
     */
    public static void newGameBoard(String[][] gameBoard ){

        // Set the default value in the game board to emty string
        for(int i = 0 ; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j]= " ";
            }
            
        }
    }


    /**
     * displayGameBoard prints out the gameBoard at every instance
     * @param gameBoard represents the orginal gameBoard on which the users a playing
     */
    public static void displayGameBoard(String[][] gameBoard){
        
        // For each list in the multi dimentional array 

        for(String[] m : gameBoard){
            
            for(String e:m){
                System.out.print("| "+e);
            }
            System.out.print("|");
            System.out.println();
        }
        
        
        
            }


    }

