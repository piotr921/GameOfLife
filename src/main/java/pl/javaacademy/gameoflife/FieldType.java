package pl.javaacademy.gameoflife;

import java.util.ArrayList;
import java.util.List;

import static pl.javaacademy.gameoflife.Neighbours.*;

enum FieldType {
    TOP_LEFT_CORNER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    TOP_RIGHT_CORNER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    DOWN_LEFT_CORNER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    DOWN_RIGHT_CORNER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP_RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    TOP_BORDER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    LEFT_BORDER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP_RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    RIGHT_BORDER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    DOWN_BORDER {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP_RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    },
    MIDDLE {
        @Override
        List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(TOP_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP.neighbourIndex(boardSize, cellIndex));
            indexes.add(TOP_RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(RIGHT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_LEFT.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN.neighbourIndex(boardSize, cellIndex));
            indexes.add(DOWN_RIGHT.neighbourIndex(boardSize, cellIndex));
            return indexes;
        }
    };

    abstract List<Integer> calculateNeighboursIndexes(int boardSize, int cellIndex);
}
