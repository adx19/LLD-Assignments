public class LadderRule implements Rule{
  public int apply(Player p, Board b, int pos, int diceValue){
    if (p.postion == 0) return pos;
    for(Ladder ladder: b.ladder){
      if(ladder.start == pos){
        System.out.println("Player " + p.name + " has gone up ladder placed at " + ladder.start);
        return ladder.end; 
      }
    }

    return pos;
  }
}
