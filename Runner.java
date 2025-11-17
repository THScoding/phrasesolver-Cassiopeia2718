/*
 * Activity 2.2.2
 *
 * The runner for the PhraseSolverGame
 */
import java.util.Scanner;
public class Runner
{
  public static void main(String[] args) 
  {
    PhraseSolver p = new PhraseSolver(new Scanner(System.in)); 
    p.play();
  }

} 
