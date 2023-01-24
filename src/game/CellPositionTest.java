package game;

import game.moveObjects.Box;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellPositionTest {

    @Test
    void row() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = false;

        if (pos.row() == 5) result = true;

        assertEquals(exp, result);

    }

    @Test
    void column() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = false;

        if (pos.column() == 6) result = true;

        assertEquals(exp, result);
    }

    @Test
    void isValid() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = false;

        if (pos.isValid()) result = true;

        assertEquals(exp, result);

    }

    @Test
    void testClone() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = false;

        CellPosition newPos = pos.clone();

        if (pos.equals(newPos)) result = true;

        assertEquals(exp, result);
    }

    @Test
    void next() {
        Game game = new Game();
        Yard yard = new Yard(5,5,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createBox(1,1);
        Box box = yard.box(new CellPosition(1,1));

        CellPosition pos = box.position().next(Direction.east());
        boolean exp = true;
        boolean result = false;

        if (pos.equals(new CellPosition(1,2))) result = true;

        assertEquals(exp, result);

    }

    @Test
    void hasNext() {
        Game game = new Game();
        Yard yard = new Yard(5,5,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createBox(1,1);
        Box box = yard.box(new CellPosition(1,1));

        CellPosition pos = box.position().next(Direction.east());
        boolean exp = true;
        boolean result = false;

        if (pos.hasNext(Direction.east())) result = true;

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        CellPosition pos = new CellPosition(1,1);
        CellPosition newPos = new CellPosition(1,1);

        boolean exp = true;
        boolean result = false;

        result = pos.equals(newPos);

        assertEquals(exp, result);

    }
}