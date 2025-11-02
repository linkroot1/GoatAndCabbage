package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabyrinthTest {

    @Test
    void createWall() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createWall(1,1, Direction.south());

        boolean exp = true;
        boolean result = yard.isWall(new MiddlePosition(new CellPosition(1, 1), Direction.south()));

        assertEquals(exp, result);
    }

    @Test
    void createBox() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createBox(1,1);

        boolean exp = true;
        boolean result = yard.isBox(new CellPosition(1, 1));

        assertEquals(exp, result);
    }

    @Test
    void createGoat() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 100);

        boolean exp = true;
        boolean result = yard.getGoat().position().equals(new CellPosition(1, 1));

        assertEquals(exp, result);
    }

    @Test
    void createCabbage() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createCabbage(1,1);

        boolean exp = true;
        boolean result = yard.getCabbage().position().equals(new CellPosition(1, 1));

        assertEquals(exp, result);
    }

    @Test
    void createKey() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createKey(1,1);

        boolean exp = true;
        boolean result = yard.get_key().position().equals(new CellPosition(1, 1));

        assertEquals(exp, result);
    }

    @Test
    void createTeleport() {
        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createTeleport(1,1);

        boolean exp = true;
        boolean result = yard.get_teleport().position().equals(new CellPosition(1, 1));

        assertEquals(exp, result);
    }
}
