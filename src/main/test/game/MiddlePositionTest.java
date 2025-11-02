package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddlePositionTest {

    @Test
    void direction() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.direction().equals(Direction.east().opposite());

        assertEquals(exp, result);
    }

    @Test
    void cellPosition() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.cellPosition().equals(new CellPosition(1,2));

        assertEquals(exp, result);
    }

    @Test
    void testClone() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = pos.clone();

        boolean exp = true;
        boolean result = pos.equals(newPos);

        assertEquals(exp, result);
    }

    @Test
    void next() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = pos.next(Direction.east());

        boolean exp = true;
        boolean result = newPos.equals(new MiddlePosition(new CellPosition(1,2), Direction.east()));

        assertEquals(exp, result);
    }

    @Test
    void hasNext() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.hasNext(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void testCellPosition() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.cellPosition(Direction.east()).equals(new CellPosition(1,2));

        assertEquals(exp, result);
    }

    @Test
    void hasCellPosition() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.hasCellPosition(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        Yard yard = new Yard(5,5,new Game());
        MiddlePosition pos = new MiddlePosition(new CellPosition(1,1), Direction.east());
        MiddlePosition newPos = new MiddlePosition(new CellPosition(1,1), Direction.east());

        boolean exp = true;
        boolean result = pos.equals(newPos);

        assertEquals(exp, result);
    }
}
