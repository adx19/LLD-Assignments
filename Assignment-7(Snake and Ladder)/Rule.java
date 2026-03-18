public interface Rule {
  int apply(Player player, Board board, int position, int diceValue);
}
