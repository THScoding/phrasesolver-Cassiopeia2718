/*
 * Activity 2.2.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  private String name;
  private int points;
  private Scanner input;


  Player(Scanner input) {
    name = input.nextLine();
    this.setPoints(0);
    this.setName(name);
  }

  public String getName() {
    return this.name;
  }

  public int getPoints() {
    return this.points;
  }

  public void setPoints(int n){
    this.points = n;
  }
  public void setName(String name) {
    this.name = name;
  }

  public void addPoints(int n) {
    this.points += n;
  }
}