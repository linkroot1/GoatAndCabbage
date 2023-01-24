package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddlePositionTest {

    @Test
    void direction() {

        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        result = pos.direction().equals(Direction.east().opposite());

        assertEquals(exp, result);

    }

    @Test
    void cellPosition() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        result = pos.cellPosition().equals(new CellPosition(1,2));

        assertEquals(exp, result);
    }

    @Test
    void testClone() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = pos.clone();

        result = pos.equals(newPos);

        assertEquals(exp, result);
    }

    @Test
    void next() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = pos.next(Direction.east());

        result = newPos.equals(new MiddlePosition(new CellPosition(1,2), Direction.east()));

        assertEquals(exp, result);
    }

    @Test
    void hasNext() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());


        result = pos.hasNext(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void testCellPosition() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());


        result = pos.cellPosition(Direction.east()).equals(new CellPosition(1,2));

        assertEquals(exp, result);
    }

    @Test
    void hasCellPosition() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());


        result = pos.hasCellPosition(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = new MiddlePosition(new CellPosition(1,1), Direction.east());


        result = pos.equals(newPos);

        assertEquals(exp, result);
    }
}