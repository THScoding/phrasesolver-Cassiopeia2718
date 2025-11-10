/*
 * Activity 2.2.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  private Board board;
  private Player player1;
  private Player player2;

  PhraseSolver() {
    this.board = new Board();
    this.player1 = new Player();
    this.player2 = new Player();
  }

  public void play()
  {
    boolean solved = false;
    boolean currentPlayer1 = true;
    Player currentPlayer = this.player1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;

    while (!solved) 
    {
      System.out.println(this.board.getSolvedPhrase());

      currentPlayer = (currentPlayer1) ? this.player1 : this.player2;

      System.out.print(currentPlayer.getName() +  " guess: ");

      correct = board.guessLetter(input.nextLine());
  
      
      /* your code here - game logic */
         
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}