package pl.javaacademy.gameoflife;

import java.util.List;

class Board {

    private final int size;
    private Population population;

    Board(int size) {
        this.size = size;
        population = new Population(size);
    }

    Population getPopulation() {
        return population;
    }

    void drawBoard() {
        population.getCells()
                .forEach((field, cell) -> {
                    cell.displayCellState();
                    if (field.getIndex() % size == size - 1) {
                        System.out.println();
                    }
                });
    }

    void updatePopulation(List<Integer> indexesToUpdate, CellState newState) {
        indexesToUpdate.forEach(index -> population.updateCellStateByIndex(index, newState));
    }

    int calculateNoOfAliveNeighbours(int cellIndex){
        return (int) population.noOfAliveNeighbours(size, cellIndex);
    }

    int getPopulationSize(){
        return population.getSize();
    }
}
