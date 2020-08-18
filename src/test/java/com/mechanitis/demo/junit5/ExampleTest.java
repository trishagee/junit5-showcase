package com.mechanitis.demo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleTest {
    @Test
    void shouldShowSimpleAssertion() {
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("Should check all items in the list")
    void shouldCheckAllItemsInTheList() {
        List<Integer> numbers = List.of(2, 3, 5, 7);

        Assertions.assertAll(() -> assertEquals(2, numbers.get(0)),
                             () -> assertEquals(3, numbers.get(1)),
                             () -> assertEquals(5, numbers.get(2)),
                             () -> assertEquals(7, numbers.get(3)));
    }

    @Test
    @DisplayName("Should only run the test if some criteria are met")
    void shouldOnlyRunTheTestIfSomeCriteriaAreMet() {
        Assumptions.assumeTrue(Fixture.apiVersion() < 10);
        // these tests only apply to a recent API version
        assertEquals(1, 1);
    }

    @ParameterizedTest (name = "{0}")
    @DisplayName("Should create shapes with different numbers of sides")
    @ValueSource(ints = {3, 4, 5, 8, 14})
    void shouldCreateShapesWithDifferentNumbersOfSides(int expectedNumberOfSides) {
        Shape shape = new Shape(expectedNumberOfSides);
        assertEquals(expectedNumberOfSides, shape.numberOfSides());
    }

    @ParameterizedTest
    @DisplayName("Should not create shapes with invalid numbers of sides")
    @ValueSource(ints = {0, 1, 2, Integer.MAX_VALUE})
    void shouldNotCreateShapesWithInvalidNumbersOfSides(int expectedNumberOfSides) {

        assertThrows(IllegalArgumentException.class,
                     () -> new Shape(expectedNumberOfSides));
    }
}
