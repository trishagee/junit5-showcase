package com.mechanitis.demo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
