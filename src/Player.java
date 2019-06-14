import java.awt.*;
import java.util.ArrayList;

public class Player {
    private int numOfTroops = 0;
    private int troopGain = 5;
    private ArrayList<Region> ownedRegions;
    private ArrayList<Country> ownedCountries;
    private int remainingRenforcements = 2;
    private boolean isDefending = true, active = false;
    private Color color;
    private int playerNu;


    public Player(int nuPlayer) {         ownedRegions = new ArrayList<>(); ownedCountries = new ArrayList<>(); playerNu = nuPlayer; }



    public boolean isAlive() {
        return (ownedCountries.size() > 0);
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public void setActive() {
        active = !active;
    }

    public int getNumOfTroops() {
        return numOfTroops;
    }

    public void setNumOfTroops(int numOfTroops) {
        this.numOfTroops = numOfTroops;
    }

    public void setOwnedRegions(Region r) {
        if (!ownedRegions.contains(r))
            ownedRegions.add(r);
    }
    public void removeOwnedRegions(Region r) {
        if (ownedRegions.contains(r))
            ownedRegions.remove(r);
    }

    public ArrayList<Country> getOwnedCountries() {
        return ownedCountries;
    }

    public void addOwnedCountries(Country c) {
        if (!getOwnedCountries().contains(c))
            ownedCountries.add(c);
    }

    public void removeOwnedCountries(Country c) {
        if (getOwnedCountries().contains(c))
            ownedCountries.remove(c);
    }



    public int getTroopGain() {
        int additive = 0;

        if (ownedRegions.size() > 0 ) {
            for (Region r : ownedRegions)
                additive += r.getTroopGain();
            return troopGain + additive;
        } else {
            return troopGain;
        }

    }

    public int getRemainingRenforcements() {
        return remainingRenforcements;
    }

    public void setRemainingRenforcements(int r) {
        remainingRenforcements = r;
    }

    public int getPlayerNu() { return playerNu;
    }

}
