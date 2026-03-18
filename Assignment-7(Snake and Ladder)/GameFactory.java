import java.util.ArrayList;
import java.util.Queue;

public class GameFactory {
  static SnakeAndLadderGame createGame(int n, int x, String diff) {
    Board b = BoardFactory.createBoard(n);
    Queue<Player> player = PlayerFactory.createPlayer(x);
    ArrayList<Rule> rule = new ArrayList<Rule>();

    rule.add(new StartRule(diff));
    rule.add(new SnakeRule());
    rule.add(new LadderRule());
    if(diff.toLowerCase().contentEquals("difficult")){
      rule.add(new SixRule());
    }

    return new SnakeAndLadderGame(player, b, rule);
  }
}
