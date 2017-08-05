package pl.javaacademy.gameoflife;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopulationTest {

    // region data providers
    @DataProvider
    private Object[][] populationSizeProvider() {
        return new Object[][]{
                {100, 100},
                {20, 20},
                {255, 255}
        };
    }

    @DataProvider
    private Object[][] aliveCellsProvider() {
        return new Object[][]{
                {100, Arrays.asList(10, 15, 25, 30)},
                {25, Arrays.asList(0, 24)},
                {100, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)}
        };
    }
    // endregion

    @Test(dataProvider = "populationSizeProvider")
    public void populationShouldContainsNumberOfCells(int givenSize, int expectedSize) {
        // When
        Population population = new Population(givenSize);
        // Then
        assertEquals(expectedSize, population.getSize());
    }

    @Test(dataProvider = "populationSizeProvider")
    public void shouldHaveOnlyDeadCellsInNwPopulation(int givenSize, int expectedSize) {
        // Given
        Population population = new Population(givenSize);

        // When
        long deadCells = IntStream.range(0, givenSize)
                .filter(index -> population.getStateOfCell(index).equals(CellState.DEAD))
                .count();
        // Then
        assertEquals(expectedSize, deadCells);
    }

    @Test(dataProvider = "aliveCellsProvider")
    public void shouldChangeStateOfSelectedCells(int size, List<Integer> aliveCells) {
        // Given
        Population population = new Population(size);

        // When
        aliveCells.forEach(cellIndex -> population.setCellState(cellIndex, CellState.ALIVE));

        // Then
        List<Integer> readAliveCells = IntStream.range(0, population.getSize())
                .filter(cellIndex -> population.getStateOfCell(cellIndex).equals(CellState.ALIVE))
                .boxed().collect(Collectors.toList());

        assertEquals(aliveCells.size(), readAliveCells.size());
        assertTrue(aliveCells.containsAll(readAliveCells));
    }
}
