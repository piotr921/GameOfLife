package pl.javaacademy.gameoflife;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Population {
    private Map<Integer, CellState> cells;

    Population(int size) {
        cells = new HashMap<>();
        IntStream.range(0, size).forEach(index -> cells.put(index, CellState.DEAD));
    }

    int getSize() {
        return cells.size();
    }

    CellState getStateOfCell(int cellIndex) {
        return cells.get(cellIndex);
    }

    void setCellState(int cellIndex, CellState newState) {
        cells.put(cellIndex, newState);
    }
}
