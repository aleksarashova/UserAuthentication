

public class War extends Game {

    public War() {
        WarRank wr = new WarRank();
        super.makeDeck(wr.values());
    }

    @Override
    public void deal() {
        deal(26);
    }
}
