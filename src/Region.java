import java.util.ArrayList;

public class Region {
    private Player owner;
    private ArrayList<Country> countries;
    private String name;
    private int troopGain;

    public Region(String tag, ArrayList Countries, int troopValue ) {
        name = tag;
        countries = Countries;
        troopGain = troopValue;
    }

    public boolean checkOwner(Player p) {
        int sum = 0;

        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getOwner() == p) {
                sum++;
            }
        }
        if (sum == countries.size() && owner != p) {
            System.out.println(sum + " " + countries.size());

            owner = p;
            return true;
        }

        return false;

    }

    public Player getOwner() { return owner; }

    public int getTroopGain() {
        return troopGain;
    }
}
