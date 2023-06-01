import java.util.Arrays;

public class Ship {

    private String name;
    private int length;

    private Cell[] occupy;
    private int health;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.health = length; // assign health to the length of the ship
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getHealth() {
        return health;
    }

    public void setPosition(Cell cell, boolean isHorizontal) {
        occupy = new Cell[length];

        for (int i = 0; i < length; i++) {
            if (isHorizontal) {
                occupy[i] = new Cell(cell.getRow(), cell.getCol() + i);
            } else {
                occupy[i] = new Cell(cell.getRow() + i, cell.getCol());
            }
        }
    }


    public boolean isPositioned() {
        return occupy != null && occupy.length == length;
    }

    private Cell[] getCells() {
        return occupy;
    }

   public boolean isInBounds() {
    for (int i = 0; i < length; i++) {
        if (!occupy[i].isInBounds()) {
            return false;
        }
    }
    return true;
    }


    public boolean intersectsWith(Cell cell) {
        for (int i = 0; i < length; i++) {
            //check if input cell has collided with another cell already stored in occupy
            //check the cell and occupy row + cell and occupy column
            if (occupy[i].getRow() == cell.getRow() && occupy[i].getCol() == cell.getCol()) {
                return true;
            }
        } 
        return false;
    }

    public boolean intersectsWith(Ship ship) {
        //make othercells array contain info from ship method getCells() to check ships
        Cell[] otherCells = ship.getCells();

        //check the occupy array 
        for (int i = 0; i < length; i++) {
            //check each occupy array index value against each getCells() ship method array
            for (int j = 0; j < ship.getLength(); j++) {
                if (occupy[i].getRow() == otherCells[j].getRow() && occupy[i].getCol() == otherCells[j].getCol()) {
                    return true;
                }
            }
        }
        return false;
    }


    public Attack handleAttack(Cell target) {
        boolean hit = intersectsWith(target);
        
        if (hit) {
            health--;
        }

        boolean sunk = (health <= 0);

        if (hit && health > 0) { //hit
            return new Attack(target, true, null); //target, hit, not sunk
        } else if (hit && sunk) { //sunk
            return new Attack(target, true, this); //target, hit, sunk
        } else {
            return new Attack(target, false, null); //target, not hit, not sunk
        }
    }

}
    

public class Attack {

    private Cell target;
    private boolean hit;
    private Ship sunk;

    public Attack (Cell target, boolean hit, Ship sunk) {
        this.target = target;
        this.hit = hit;
        this.sunk = sunk; 
    }

    public Cell getTarget () {
        return target;
    }

    public boolean isHit () {
        if (hit == true) {
            return true;
        }
        return false;
    }

    public Ship getSunkShip () {
        if (hit == true) {
            return sunk;
        }
        return null;
    }

    public String toString () {
        if ( hit == false && sunk == null) {
            return target + " misses!" ;

        } 

        if (hit == true && sunk == null) {
            return target + " hits!" ;
        } 

        return target + " hits, and sinks the " + sunk + "!" ; 
    }
    
}