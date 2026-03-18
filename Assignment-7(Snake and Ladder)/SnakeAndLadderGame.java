import java.util.ArrayList;
import java.util.Queue;

public class SnakeAndLadderGame {
  Queue<Player> players;

  Dice dice;

  ArrayList<Rule> rule;

  Board board;

  public SnakeAndLadderGame(Queue<Player> p, Board board, ArrayList<Rule> rule) {
    this.players = p;
    this.board = board;
    this.dice = new Dice();
    this.rule = rule;
  }

  public void makeMove() {
    if (this.players.size() == 1)
      return;
    Player p = this.players.peek();
    int diceValue = this.dice.roll();
    System.out.println("Player " + p.name + " has rolled a " + diceValue);
    int newPosition = p.postion == 0 ? diceValue : p.postion + diceValue;
    int n = board.snake.length * board.snake.length;
    if (newPosition > n) {
      newPosition = p.postion; // stay in same place
    }
    for (Rule r : rule) {
      newPosition = r.apply(p, board, newPosition, diceValue);
    }

    p.postion = newPosition;
    System.out.println("Player " + p.name + " is now at cell no " + p.postion);

    if (p.postion == n) {
      System.out.println("Player " + p.name + " has finished!");
      players.poll();
      return;
    }
    if (diceValue != 6) {
      this.players.poll();
      this.players.add(p);
    }

  }
}
