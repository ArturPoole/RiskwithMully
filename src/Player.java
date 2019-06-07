public class Player {


    private int numOfTroops = 1;
    private int troopGain = 0;
    private int remainingRenforcements = 21;
    private boolean isDefending = true;


        public boolean isAlive(int numOfTroops){

            while (numOfTroops <= 0){
                return false;
            }

            return true;
        }

}
