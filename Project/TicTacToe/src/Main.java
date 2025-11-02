import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String[] board;
    static String turn;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Lets play a game call TIC-TAC-TOE");

        Scanner sc = new Scanner(System.in);
        board= new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++){
            board[a] = String.valueOf(a+1);
        }

        TicTacToe t = new TicTacToe();
        System.out.println("Welcome to 3x3 Tic Tac Toe ");
        t.printBoard(board);
        System.out.println("X : will play first.Enter a slot number to place X in : ");

        while (winner == null){
            int numInput;
            try {
                numInput = sc.nextInt();
                //check range
                if(!(numInput > 0)&&(numInput <= 9)){
                    System.out.println("Invalid input:  re-enter slot number:");
                    continue;
                }
                //check if the slot is available
                if (board[numInput - 1].equals(String.valueOf(numInput))){
                    board[numInput - 1] = turn;
                    //Toggle turn
                    turn = turn.equals("X") ? "0" : "X";

                    t.printBoard(board);
                    winner = t.checkWinner(board);
                }
                else {
                    System.out.println("Slot already taken, re-enter the slot number : ");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! re-enter slot number : ");
                sc.nextInt(); //consume invalid input to avoid infinite loop
            }
        }

        //final result
        if (winner.equalsIgnoreCase("draw")){
            System.out.println("It's draw! Thanks for playing.");
        }
        else {
            System.out.println("Congratulation! "+winner+" 's have won! Thanks for playing.");
        }
        sc.close();
    }
}