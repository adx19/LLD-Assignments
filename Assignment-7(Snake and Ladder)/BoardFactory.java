import java.util.HashSet;
import java.util.Random;

public class BoardFactory {
  static Board createBoard(int n) {
    Board board = new Board();
    board.snake = new Snake[n];
    board.ladder = new Ladder[n];
    Random random = new Random();
    HashSet<Integer> visited = new HashSet<>();
    int size = n * n;
    int i = 0;
    while (i < n) {
      int start = random.nextInt(size - 1) + 2;
      int end = random.nextInt(start - 1) + 1;

      if (end >= start)
        continue;

      if (visited.contains(start) || visited.contains(end))
        continue;

      board.snake[i] = new Snake(start, end);
      visited.add(start);
      visited.add(end);

      i++;
    }

    i = 0;

    while (i < n) {
      int start = random.nextInt(size - 1) + 1;
      int end = random.nextInt(size - start) + start + 1;

      if (end <= start)
        continue;

      if (visited.contains(start) || visited.contains(end))
        continue;

      board.ladder[i] = new Ladder(start, end);
      visited.add(start);
      visited.add(end);

      i++;
    }

    return board;
  }
}
