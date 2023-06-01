import java.util.ArrayList;
import java.util.List;

public class Fleet {

    public static final String[] names = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
    public static final int[] lengths = {5, 4, 3, 3, 2};


    private List<Ship> fleet; //we need this arraylist to store all the ships in the fleet
    private int shipsRemain;



    public Fleet() {
        fleet = new ArrayList<>();

    }

    public List<Ship> getShips() {
        return fleet ;  
    }

    public int shipsRemaining() {
        int shipsRemaining = 5;
        
        for (Ship ship : fleet) {
            if (ship.getHealth() == 0) {
                shipsRemaining-- ; 
            }
        }

        return shipsRemaining ; 
    }

    public boolean addShip(Ship ship) {
        
        if (!ship.isInBounds() || !ship.isPositioned()) {
            return false;
        }

        for (int i = 0; i < fleet.size(); i++) {
            Ship currentShip = fleet.get(i);

            if (ship.intersectsWith(currentShip)) {
                return false;
            }
        }

        fleet.add(ship); // Add the ship to the fleet
        return true;
    }

    public Ship getShipAt(Cell cell) {
        for (Ship ship : fleet) { //check each individual ship in the fleet
            if (ship.intersectsWith(cell)) {
                return ship;
            }
        }
        return null;
    }

    public Attack handleAttack(Cell target) {
        Ship ship = getShipAt(target); //get the target location of ship 
        
        if (ship != null) {
            return ship.handleAttack(target);
        }
        
        return new Attack(target, false, null);
    }


}

    





















