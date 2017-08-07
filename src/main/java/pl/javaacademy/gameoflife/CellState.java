package pl.javaacademy.gameoflife;

enum CellState {
    ALIVE {
        @Override
        void displayState() {
            System.out.print("o");
        }
    },
    DEAD {
        @Override
        void displayState() {
            System.out.print("+");
        }
    };

    abstract void displayState();
}
