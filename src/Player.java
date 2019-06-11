public class Player {


    private int numOfTroops = 1;
    private int troopGain = 0;
    private int remainingRenforcements = 21;
    private boolean isDefending = true, isActive = false;


    public Player() {}



    public boolean isAlive(int numOfTroops){

        while (numOfTroops <= 0){
            return false;
        }

        return true;
    }


    public void setActive() {
        isActive = !isActive;
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

    public int setRemainingRenforcements() {
        return remainingRenforcements;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean defending) {
        isDefending = defending;
    }


}
