public class StartRule implements Rule {
    private boolean requireSix;

    public StartRule(String diff) {
        this.requireSix = diff.equalsIgnoreCase("difficult");
    }
  public int apply(Player p, Board b, int pos, int diceValue) {
        if (p.postion == 0) {

            if (requireSix) {
                return (Math.abs(p.postion - pos) == 6) ? 1 : 0;
            } else {
                return Math.abs(p.postion - pos);
            }
        }

        return p.postion + Math.abs(p.postion - pos);
  }
}
