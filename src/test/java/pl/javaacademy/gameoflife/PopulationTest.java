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
                {10},
                {6},
                {8}
        };
    }

    @DataProvider
    private Object[][] aliveCellsProvider() {
        return new Object[][]{
                {10, Arrays.asList(10, 15, 25, 30)},
                {5, Arrays.asList(0, 24)},
                {10, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)}
        };
    }

    @DataProvider
    private Object[][] cornerProvider() {
        return new Object[][]{
                {3, Arrays.asList(0, 2, 6, 8)},
                {5, Arrays.asList(0, 4, 20, 24)},
                {10, Arrays.asList(0, 9, 90, 99)},
                {7, Arrays.asList(0, 6, 42, 48)}
        };
    }
    // endregion

    @Test(dataProvider = "populationSizeProvider")
    public void populationShouldContainsNumberOfCells(int givenSize) {
        // When
        Population population = new Population(givenSize);
        // Then
        assertEquals(givenSize * givenSize, population.getSize());
    }

    @Test(dataProvider = "populationSizeProvider")
    public void shouldInitializeEveryCellAsDead(int givenSize) {
        // Given
        Population population = new Population(givenSize);

        // When
        long noOfDeadCells = IntStream.range(0, givenSize * givenSize)
                .filter(index -> population.getCellStateByIndex(index).equals(CellState.DEAD))
                .count();

        // Then
        assertEquals(givenSize * givenSize, noOfDeadCells);
    }

    @Test(dataProvider = "aliveCellsProvider")
    public void shouldSetCellByIndex(int givenSize, List<Integer> aliveCellIndexes) {
        // Given
        Population population = new Population(givenSize);

        // When
        aliveCellIndexes.forEach(index ->
                population.updateCellStateByIndex(index, CellState.ALIVE));

        // Then
        List<Integer> readAliveIndexes = IntStream.range(0, givenSize * givenSize)
                .filter(index -> population.getCellStateByIndex(index).equals(CellState.ALIVE))
                .boxed().collect(Collectors.toList());

        assertEquals(aliveCellIndexes.size(), readAliveIndexes.size());
        assertTrue(aliveCellIndexes.containsAll(readAliveIndexes));
    }

/*    @Test(dataProvider = "cornerProvider")
    public void shouldReturnCornerTypeForProperFields(int givenSize,
                                                      List<Integer> cornerIndexes) {
        // Given
        Population population = new Population(givenSize);

        // When
        List<Integer> readCornerIndexes = IntStream.range(0, givenSize * givenSize)
                .filter(index -> population.getFieldTypeByIndex(index).equals(FieldType.CORNER))
                .boxed().collect(Collectors.toList());

        // Then
        assertEquals(cornerIndexes.size(), readCornerIndexes.size());
        assertTrue(cornerIndexes.containsAll(readCornerIndexes));

    }*/
}
