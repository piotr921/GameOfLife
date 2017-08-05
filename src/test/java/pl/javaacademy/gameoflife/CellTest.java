package pl.javaacademy.gameoflife;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldInitializeNewCellWithDeadState() {
        // When
        Cell cell = new Cell();

        // Then
        assertEquals(CellState.DEAD, cell.getState());
    }

    @Test
    public void shouldSetCellState() {
        // Given
        Cell cell = new Cell();

        // When
        cell.setState(CellState.ALIVE);

        // Then
        assertEquals(CellState.ALIVE, cell.getState());
    }
}
