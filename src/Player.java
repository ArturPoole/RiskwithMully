import java.awt.*;

public class Player {
    private int numOfTroops = 0;
    private int troopGain = 2;
    private int remainingRenforcements = 1;
    private boolean isDefending = true, active = false;
    private Color color;


    public Player() { }



    public boolean isAlive(int numOfTroops){

        while (numOfTroops <= 0){
            return false;
        }

        return true;
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

    public int getTroopGain() {
        return troopGain;
    }

    public void setTroopGain(int troopGain) {
        this.troopGain = troopGain;
    }

    public int getRemainingRenforcements() {
        return remainingRenforcements;
    }

    public void setRemainingRenforcements(int r) {
         remainingRenforcements = r;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean defending) {
        isDefending = defending;
    }

    public boolean getActive() {return active;}

    public void setActive(boolean b) {active = b;}


}
