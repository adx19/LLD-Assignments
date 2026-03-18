public class Main {
  public static void main(String[] args){
    int n = 10;
    int x = 4;
    String diff = "easy";
    SnakeAndLadderGame game = GameFactory.createGame(n, x, diff);
    for(int i = 0; i<50; i++){
      game.makeMove();
    }
  }
}
