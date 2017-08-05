package pl.javaacademy.gameoflife;

public enum Neighbours {
    TOP_LEFT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex - boardSize - 1;
        }
    },
    TOP {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex - boardSize;
        }
    },
    TOP_RIGHT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex - boardSize + 1;
        }
    },
    LEFT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex - 1;
        }
    },
    RIGHT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex + 1;
        }
    },
    DOWN_RIGHT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex + boardSize - 1;
        }
    },
    DOWN {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex + boardSize;
        }
    },
    DOWN_LEFT {
        @Override
        int neighbourIndex(int boardSize, int cellIndex) {
            return cellIndex + boardSize + 1;
        }
    };

    abstract int neighbourIndex(int boardSize, int cellIndex);
}
