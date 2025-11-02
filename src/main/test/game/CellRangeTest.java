package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellRangeTest {

    @Test
    void min() {
        CellRange range = new CellRange(5,6);

        boolean exp = true;
        boolean result = range.min() == 5;

        assertEquals(exp, result);
    }

    @Test
    void max() {

        CellRange range = new CellRange(5,6);

        boolean exp = true;
        boolean result = range.max() == 6;

        assertEquals(exp, result);
    }

    @Test
    void length() {
        CellRange range = new CellRange(5,6);

        boolean exp = true;
        boolean result = range.length() == 2;

        assertEquals(exp, result);
    }

    @Test
    void isValidRange() {
        boolean exp = true;
        boolean result = CellRange.isValidRange(5,6);

        assertEquals(exp, result);
    }
}
