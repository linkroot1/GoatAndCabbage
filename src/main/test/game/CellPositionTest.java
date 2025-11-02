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
        boolean result = pos.row() == 5;

        assertEquals(exp, result);
    }

    @Test
    void column() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = pos.column() == 6;

        assertEquals(exp, result);
    }

    @Test
    void isValid() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);
        boolean exp = true;
        boolean result = pos.isValid();

        assertEquals(exp, result);
    }

    @Test
    void testClone() {
        Game game = new Game();
        Yard yard = new Yard(7,7, game);
        CellPosition pos = new CellPosition(5,6);

        CellPosition newPos = pos.clone();
        boolean exp = true;
        boolean result = pos.equals(newPos);

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
        boolean result = pos.equals(new CellPosition(1, 2));

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
        boolean result = pos.hasNext(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        CellPosition pos = new CellPosition(1,1);
        CellPosition newPos = new CellPosition(1,1);

        boolean exp = true;
        boolean result = pos.equals(newPos);

        assertEquals(exp, result);
    }
}
