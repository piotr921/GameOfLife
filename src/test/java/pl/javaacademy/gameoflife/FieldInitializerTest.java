package pl.javaacademy.gameoflife;

import com.sun.xml.internal.ws.spi.db.FieldSetter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static pl.javaacademy.gameoflife.FieldType.*;

public class FieldInitializerTest {

    // region data providers
    @DataProvider
    private Object[][] cornerIndexProvider() {
        return new Object[][]{
                {5, 0},
                {5, 4},
                {5, 20},
                {5, 24},
                {7, 6},
                {7, 42},
                {10, 99}
        };
    }

    @DataProvider
    private Object[][] borderIndexProvider() {
        return new Object[][]{
                {5, 1},
                {5, 2},
                {5, 3},
                {5, 5},
                {5, 10},
                {5, 15},
                {5, 9},
                {5, 14},
                {5, 19},
                {5, 21},
                {5, 22},
                {5, 23},
        };
    }

    @DataProvider
    private Object[][] allTypesProvider() {
        return new Object[][]{
                {3, Arrays.asList(
                        CORNER, BORDER, CORNER,
                        BORDER, MIDDLE, BORDER,
                        CORNER, BORDER, CORNER)}
        };
    }
    // endregion

    @Test(dataProvider = "cornerIndexProvider")
    public void shouldRecognizeFieldAsCorner(int givenSize, int index) {
        // Given
        FieldInitializer initializer = new FieldInitializer();

        // When
        FieldType recognizedType = initializer.selectFieldType(givenSize, index);

        // Then
        assertEquals(recognizedType, CORNER);
    }

    @Test(dataProvider = "borderIndexProvider")
    public void shouldRecognizeFieldAsBorder(int givenSize, int index) {
        // Given
        FieldInitializer initializer = new FieldInitializer();

        // When
        FieldType recognizedType = initializer.selectFieldType(givenSize, index);

        // Then
        assertEquals(recognizedType, BORDER);
    }

    @Test(dataProvider = "allTypesProvider")
    public void shouldRecognizeAllFieldsTypes(int givenSize, List<FieldType> expectedResults) {
        // Given
        FieldInitializer initializer = new FieldInitializer();

        // When
        List<FieldType> recognizedTypes = IntStream.range(0, givenSize * givenSize)
                .mapToObj(index -> initializer.selectFieldType(givenSize, index))
                .collect(Collectors.toList());

        // Then
        List<Boolean> areEquals = IntStream.range(0, expectedResults.size())
                .mapToObj(index -> expectedResults.get(index).equals(recognizedTypes.get(index)))
                .collect(Collectors.toList());

        List<Boolean> marksInAreEquals = areEquals.stream().distinct().collect(Collectors.toList());

        assertTrue(marksInAreEquals.contains(true));
        assertFalse(marksInAreEquals.contains(false));
    }
}
