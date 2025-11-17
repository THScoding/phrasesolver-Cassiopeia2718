/*
 * Activity 2.2.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

  
public class PhraseSolver
{
  private Board board;
  private Player player1;
  private Player player2;
  private boolean currentPlayer1;
  private Scanner input;
  public ArrayList<String> guessedLetters;
  private boolean solved;

  PhraseSolver(Scanner input) {
    this.board = new Board();
    System.out.println("Player 1, what is your name?");
    this.player1 = new Player(input);
    System.out.println("Player 2, what is your name?");
    this.player2 = new Player(input);
    this.currentPlayer1 = true;
    this.input = input;
    this.solved = false;
    this.guessedLetters = new ArrayList<>(Arrays.asList(new String[]{"", " "}));
  }

  public void play()
  {

    while (!this.solved) 
    {
      System.out.println(this.board.getSolvedPhrase());
      this.board.setLetterValue();
      System.out.print(this.getCurrentPlayer().getName() +  " guess: ");
      this.guess();
      this.swapCurrentPlayer();
    }

    System.out.println(this.player1.getName() + " had " + this.player1.getPoints() + " points.");
    System.out.println(this.player2.getName() + " had " + this.player2.getPoints() + " points.");
    if(this.player1.getPoints() > this.player2.getPoints()) {
      System.out.println(this.player1.getName() + " won!");
    } else if(this.player1.getPoints() < this.player2.getPoints()) {
      System.out.println(this.player2.getName() + " won!");
    } else {
      System.out.println("You tied!");
    }
    
  }

  public void guess() {
    String guess = this.input.nextLine().toLowerCase();

    if(guess.length() == 1 && !this.guessedLetters.contains(guess)) {
      if(this.board.guessLetter(guess)) {
        this.getCurrentPlayer().addPoints(this.board.getCurrentLetterValue());
        this.guessedLetters.add(guess);
      }
    } else if(guess.length() > 1) {
      if(this.board.isSolved(guess)) {
        System.out.println("You found the phrase!!");
        this.getCurrentPlayer().addPoints(5);
        this.solved = true;
      } else {System.out.println("Incorrect phrase");}
    } else {
      System.out.println("Invalid guess");
      this.guess();
    }
  }

  public Player getCurrentPlayer() {
    return (this.getCurrentPlayer1()) ? this.player1 : this.player2;
  }
  
  public boolean getCurrentPlayer1() {
    return this.currentPlayer1;
  }

  public void swapCurrentPlayer() {
    this.currentPlayer1 = !this.currentPlayer1;
  }
}