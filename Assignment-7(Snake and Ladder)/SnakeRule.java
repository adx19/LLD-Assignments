public class SnakeRule implements Rule{
  public int apply(Player p, Board b, int pos, int diceValue){
    if (p.postion == 0) return pos;
    for(Snake snake: b.snake){
      if(snake.start == pos){
        System.out.println("Player " + p.name + " has been bitten by snake placed at " + snake.start);
        return snake.end;
      }
    }

    return pos;
  }
}
