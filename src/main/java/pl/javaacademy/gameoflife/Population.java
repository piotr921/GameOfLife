package pl.javaacademy.gameoflife;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Population {
    private Map<Field, Cell> cells;

    Population(int boardSize) {
        cells = new HashMap<>();
        FieldInitializer initializer = new FieldInitializer();
        IntStream.range(0, boardSize * boardSize).forEach(index ->
                cells.put(
                        new Field(index, initializer.selectFieldType(boardSize, index)),
                        new Cell()));
    }

    int getSize() {
        return cells.size();
    }

    CellState getCellStateByIndex(int index) {
        return cells.entrySet().stream()
                .filter(cell -> index == cell.getKey().getIndex())
                .collect(Collectors.toList())
                .get(0)
                .getValue()
                .getState();
    }

    void updateCellStateByIndex(int index, CellState newState) {
        Field key = getKeyByIndex(index);
        Cell cell = cells.get(key);
        cell.setState(newState);
        cells.put(key, cell);
    }

    private Field getKeyByIndex(int index) {
        return cells.entrySet().stream()
                .filter(cell -> index == cell.getKey().getIndex())
                .collect(Collectors.toList())
                .get(0)
                .getKey();
    }

    FieldType getFieldTypeByIndex(int index) {
        return cells.entrySet().stream()
                .filter(cell -> cell.getKey().getIndex() == index)
                .collect(Collectors.toList())
                .get(0)
                .getKey()
                .getType();
    }
}
