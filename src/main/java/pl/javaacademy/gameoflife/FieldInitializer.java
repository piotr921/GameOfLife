package pl.javaacademy.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FieldInitializer {
    private List<Integer> cornerIndexes;
    private Integer topLeftCornerIndex;
    private Integer topRightCornerIndex;
    private Integer downLeftCornerIndex;
    private Integer downRightCornerIndex;
    private List<Integer> topBorderIndexes;
    private List<Integer> leftBorderIndexes;
    private List<Integer> rightBorderIndexes;
    private List<Integer> downBorderIndexes;

    FieldType selectFieldType(int boardSize, int cellIndex) {
        initializeCornerIndexes(boardSize);
        initializeBorderIndexes(boardSize);
        FieldType selectedType;

        if (topLeftCornerIndex == cellIndex) {
            selectedType = FieldType.TOP_LEFT_CORNER;
        } else if (topRightCornerIndex == cellIndex) {
            selectedType = FieldType.TOP_RIGHT_CORNER;
        } else if (downLeftCornerIndex == cellIndex) {
            selectedType = FieldType.DOWN_LEFT_CORNER;
        } else if (downRightCornerIndex == cellIndex) {
            selectedType = FieldType.DOWN_RIGHT_CORNER;
        } else if (topBorderIndexes.contains(cellIndex)) {
            selectedType = FieldType.TOP_BORDER;
        } else if (leftBorderIndexes.contains(cellIndex)) {
            selectedType = FieldType.LEFT_BORDER;
        } else if (rightBorderIndexes.contains(cellIndex)) {
            selectedType = FieldType.RIGHT_BORDER;
        } else if (downBorderIndexes.contains(cellIndex)) {
            selectedType = FieldType.DOWN_BORDER;
        } else {
            selectedType = FieldType.MIDDLE;
        }
        return selectedType;
    }

    private void initializeCornerIndexes(int boardSize) {
        topLeftCornerIndex = 0;
        topRightCornerIndex = boardSize - 1;
        downLeftCornerIndex = (boardSize * boardSize) - boardSize;
        downRightCornerIndex = boardSize * boardSize - 1;

        initializeCornerIndexesList();
    }

    private void initializeCornerIndexesList() {
        cornerIndexes = new ArrayList<>();
        cornerIndexes.add(topLeftCornerIndex);
        cornerIndexes.add(topRightCornerIndex);
        cornerIndexes.add(downLeftCornerIndex);
        cornerIndexes.add(downRightCornerIndex);
    }

    private void initializeBorderIndexes(int boardSize) {
        topBorderIndexes = new ArrayList<>();
        leftBorderIndexes = new ArrayList<>();
        rightBorderIndexes = new ArrayList<>();
        downBorderIndexes = new ArrayList<>();

        topBorderIndexes.addAll(findLeftBorderIndexes(boardSize));
        leftBorderIndexes.addAll(findRightBorderIndexes(boardSize));
        rightBorderIndexes.addAll(findTopBorderIndexes(boardSize));
        downBorderIndexes.addAll(findBottomBorderIndexes(boardSize));
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