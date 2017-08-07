package pl.javaacademy.gameoflife;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int noOfRounds = 10;

    public static void main(String[] args) {

        Board board = new Board(5);
        List<Integer> startAlive = Arrays.asList(11,12,13);
        NewStateCalculator stateCalculator = new NewStateCalculator();

        board.updatePopulation(startAlive, CellState.ALIVE);
        board.drawBoard();

        for (int i = 0; i < noOfRounds; i++) {
            stateCalculator.calculate(board);
            board.drawBoard();
        }
    }
}
