package pl.javaacademy.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FieldInitializer {

    private List<Integer> cornerIndexes;
    private List<Integer> borderIndexes;

    FieldType selectFieldType(int boardSize, int cellIndex) {
        initializeCornerIndexes(boardSize);
        initializeBorderIndexes(boardSize);
        FieldType selectedType;
        //search for corners
        if (cornerIndexes.contains(cellIndex)) {
            selectedType = FieldType.CORNER;
        } else if (borderIndexes.contains(cellIndex)) {
            selectedType = FieldType.BORDER;
        } else {
            selectedType = FieldType.MIDDLE;
        }
        return selectedType;
    }

    private void initializeCornerIndexes(int boardSize) {
        cornerIndexes = new ArrayList<>();
        cornerIndexes.add(0);
        cornerIndexes.add(boardSize - 1);
        cornerIndexes.add((boardSize * boardSize) - boardSize);
        cornerIndexes.add(boardSize * boardSize - 1);
    }

    private void initializeBorderIndexes(int boardSize) {
        borderIndexes = new ArrayList<>();
        borderIndexes.addAll(findLeftBorderIndexes(boardSize));
        borderIndexes.addAll(findRightBorderIndexes(boardSize));
        borderIndexes.addAll(findTopBorderIndexes(boardSize));
        borderIndexes.addAll(findBottomBorderIndexes(boardSize));
    }

    private List<Integer> findLeftBorderIndexes(int boardSize) {
        return IntStream.range(0, boardSize * boardSize)
                .filter(index -> (index % boardSize == 0))
                .filter(index -> !cornerIndexes.contains(index))
                .boxed().collect(Collectors.toList());
    }

    private List<Integer> findRightBorderIndexes(int boardSize) {
        return IntStream.range(0, boardSize * boardSize)
                .filter(index -> (index % boardSize == boardSize - 1))
                .filter(index -> !cornerIndexes.contains(index))
                .boxed().collect(Collectors.toList());
    }

    private List<Integer> findTopBorderIndexes(int boardSize) {
        return IntStream.range(0, boardSize * boardSize)
                .filter(index -> (index / boardSize == 0))
                .filter(index -> !cornerIndexes.contains(index))
                .boxed().collect(Collectors.toList());
    }

    private List<Integer> findBottomBorderIndexes(int boardSize) {
        return IntStream.range(0, boardSize * boardSize)
                .filter(index -> (index / boardSize == boardSize - 1))
                .filter(index -> !cornerIndexes.contains(index))
                .boxed().collect(Collectors.toList());
    }
}
