package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabyrinthTest {

    @Test
    void createWall() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createWall(1,1, Direction.south());
        if(yard.isWall(new MiddlePosition(new CellPosition(1,1), Direction.south()))) result = true;

        assertEquals(result, exp);

    }

    @Test
    void createBox() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createBox(1,1);
        if(yard.isBox(new CellPosition(1,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void createGoat() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 100);
        if(yard.getGoat().position().equals(new CellPosition(1,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void createCabbage() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createCabbage(1,1);
        if(yard.getCabbage().position().equals(new CellPosition(1,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void createKey() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createKey(1,1);
        if(yard.get_key().position().equals(new CellPosition(1,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void createTeleport() {
        boolean result = false;
        boolean exp = true;

        Yard yard = new Yard(3,3, new Game());
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createTeleport(1,1);
        if(yard.get_teleport().position().equals(new CellPosition(1,1))) result = true;

        assertEquals(result, exp);
    }
}