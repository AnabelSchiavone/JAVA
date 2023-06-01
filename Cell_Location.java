public class Cell {

    public static final String[] ROW_LABELS = {"A","B","C","D","E","F","G","H"};
    public static final String[] COL_LABELS = {"1","2","3","4","5","6","7","8"};

    public static final int ROW_COUNT = 8 ;
    public static final int COL_COUNT = 8 ;

    private int row; //create the class variable/parameter to use
    private int column;


    public Cell(int row, int column) {
        this.row = row; //this.row defines which "row" variable the method is referring to.
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

    public boolean isInBounds() { //if condition to ensure input is inbounds between A-H and 1-8
        if ((row >= 0 && row <= ROW_COUNT-1) && (column >= 0 && column <= COL_COUNT-1)) {
            //ROW_COUNT-1: becasue the first valid row is 0
            return true;
        }
        return false;
    }

    public String toString() {
        if (!isInBounds()) { //boolean false is isInBounds returns false
            return "INVALID";
        } else {
            return ROW_LABELS[row] + COL_LABELS[column];
        }
    }

    public static Cell fromString(String position) {
    

        if (position.length() != 2) { //check if the string is length of 2 - only option - A1, A2 - if not 2 then therfore incorrect and false
            return null;
        }

        char rowChar = position.charAt(0); //first character of the string - row of the cell. The charAt method - index 0, which returns the first character of the string.
        char colChar = position.charAt(1);

        int row = Character.toUpperCase(rowChar) - 'A'; //transfer letter into digit - to uppercase also
        int col = colChar - '1';

        if ( (row < 0 || row >= ROW_COUNT) || (col < 0 || col >= COL_COUNT)) {
            return null;
        }
        return new Cell(row, col);
    }
}
