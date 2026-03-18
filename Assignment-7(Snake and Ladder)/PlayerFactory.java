import java.util.LinkedList;
import java.util.Queue;
public class PlayerFactory {
  static Queue<Player> createPlayer(int x){
    Queue<Player> order = new LinkedList<Player>();
    int i = 1;
    while(order.size() != x){
      String name = "P" + i;
      Player p = new Player(name,  0);

      order.add(p);
      i++;
    }

    return order;
  } 
}
