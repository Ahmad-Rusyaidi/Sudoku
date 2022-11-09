package computationLogic;

import application.sudokuGame;

public class SudokuUtilities {

    /**
     * Copy the values from one sudoku grid into another
     *
     * Note: O(n^2) Runtime Complexity
     * @param oldArray
     * @param newArray
     */
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
        for (int xIndex = 0; xIndex < sudokuGame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < sudokuGame.GRID_BOUNDARY; yIndex++ ){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }

    /**
     * Creates and returns a new Array with the same values as the inputted Array.
     *
     * @param oldArray
     */
    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] newArray = new int[sudokuGame.GRID_BOUNDARY][sudokuGame.GRID_BOUNDARY];
        for (int xIndex = 0; xIndex < sudokuGame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < sudokuGame.GRID_BOUNDARY; yIndex++ ){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }

        return newArray;
    }
}
