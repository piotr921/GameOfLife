package pl.javaacademy.gameoflife;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Population {
    private Map<Integer, Cell> cells;

    Population(int size) {
        cells = new HashMap<>();
        IntStream.range(0, size).forEach(index -> cells.put(index, new Cell()));
    }

    int getSize() {
        return cells.size();
    }

    CellState getStateOfCell(int cellIndex) {
        return cells.get(cellIndex).getState();
    }

    void setCellState(int cellIndex, CellState newState) {
        Cell newCell = cells.get(cellIndex);
        newCell.setState(newState);
        cells.put(cellIndex, newCell);
    }
}
