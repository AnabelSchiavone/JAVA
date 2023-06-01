public class Guesses {
   
    private Cell[][] guesses;
    private int number;

    // constructor that initializes the guesses array to all nulls
    public Guesses() {
        guesses = new Cell[100][100]; //create 2d array 
        number = 0; //set count guess to 0
    }

    //addguess method - accep cell instance, void, add cell to array if returns null (unique)
    public void addGuess(Cell cell) {
        int row = cell.getRow(); //retrieve row guess input
        int col = cell.getCol(); //retrieve column guess input
        
        //decide whether to add/not add guess to the array; if null(unique) - add to array and +1 to number
        if (guesses[row][col] == null) { 
            guesses[row][col] = cell; //add to array
            number++; // +1 guess
        }
    }

    // take the same guess that was checked in addGuess and reveal whether it was dupliate or not
    public boolean isGuessed(Cell cell) {
        int row = cell.getRow(); //retrieve same row guess input
        int col = cell.getCol(); //retrieve same column guess input
        
        if (guesses[row][col] == null) {
            return false;
        }
        return true;
        
    }

    // method to get the total number of valid guesses made
    public int getTotalGuesses() {
        return number;
    }
}
