//package oasisintern;

import java.util.*;

class Game {

    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;
    public int score;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    Game() {
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }

    void userInput() {
        System.out.println("Guess the number between 1 to 100:");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    Boolean check() {

        noOfGuesses++;
        if (inputNumber == number && noOfGuesses < 6) {
            System.out.format("Right guess!!!....You WON, it is %d\nYou guessed it in %d attempts", number, noOfGuesses);
            System.out.println(" ");

            return true;
        } else if (noOfGuesses == 5) {
            System.out.println("No of Attempts is over......You LOST..... Try again ");
                     return true;
        } else if (inputNumber < number && noOfGuesses < 5) {
            System.out.println("Try higher number...");
        } else if (inputNumber > number && noOfGuesses < 5) {
            System.out.println("Try lower number...");
        }

        return false;
    }
   int calc_score(){
  	 int diff;
  	 diff=Math.abs(inputNumber-number);
  	 score=100-diff;
  	 
  	 return score;
   }
}

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to PLAY the Game");
        System.out.println("Press 0 to EXIT ");
        
        int count = 0;
        int s = sc.nextInt();
        do{
           switch(s) {
           		case 1:
                Game g = new Game();
                boolean b = false;
                while (!b) {
                    g.userInput();
                    b = g.check();

                }
                count++;
                System.out.println("Total no of round played:....  " + count);
                System.out.println("Score....."+g.calc_score());
                System.out.println("**************************************************");
                System.out.println("Press 1 to PLAY the Game");
                System.out.println("Press 0 to EXIT ");

                s = sc.nextInt();
                break;
          
            case 0:
                System.out.println("Thank You for playing.....!!!");
                System.exit(0);
            default:
            	 System.out.println("Invalid option");
            	 System.out.println("Press 1 to PLAY the Game");
                 System.out.println("Press 0 to EXIT ");
                 s = sc.nextInt();
                 break;

            }
           
        }while(true);
    }
}
