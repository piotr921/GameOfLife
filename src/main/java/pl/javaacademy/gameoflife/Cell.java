package pl.javaacademy.gameoflife;

class Cell {
    private CellState state;

    Cell() {
        state = CellState.DEAD;
    }

    CellState getState() {
        return state;
    }

    void setState(CellState state) {
        this.state = state;
    }
}
