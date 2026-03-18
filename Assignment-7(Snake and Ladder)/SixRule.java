import java.util.HashMap;

public class SixRule implements Rule{
  private HashMap<Player, Integer> sixCount = new HashMap<>();

  public int apply(Player p, Board b, int pos, int diceValue){
    int lastRoll = diceValue;
    if(lastRoll == 6){
      sixCount.put(p, sixCount.getOrDefault(p, 0) + 1);
    }else{
      sixCount.put(p, 0);
    }

    if(sixCount.get(p) == 3){
      sixCount.put(p, 0);
      return p.postion;
    }

    return pos;
  }
}
