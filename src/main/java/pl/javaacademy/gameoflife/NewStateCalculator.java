package pl.javaacademy.gameoflife;

import java.util.List;
import java.util.stream.IntStream;

class NewStateCalculator {

    void calculate(Board board) {
        IntStream.range(0, board.getPopulationSize())
                .forEach(index -> updateSingleCell(board, index));
    }

    private void updateSingleCell(Board board, int cellIndex) {
        int noOfAliveNeighbours = board.calculateNoOfAliveNeighbours(cellIndex);
        // todo change cell state here!!
    }
}
