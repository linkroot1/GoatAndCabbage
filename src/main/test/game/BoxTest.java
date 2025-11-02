package game;

import game.moveObjects.Box;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxTest {

    @Test
    void moveToEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);

        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createBox(1,1);
        labyrinth.createCabbage(2,2);

        labyrinth.createGoat(1,2,10);

        boolean result = yard.getGoat().moveBoxYourself(Direction.east());
        boolean exp = true;

        assertEquals(exp, result);
    }

    @Test
    void moveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createWall(1,1, Direction.east());
        labyrinth.createCabbage(2,2);
        labyrinth.createGoat(1,2,10);
        labyrinth.createBox(1,1);

        boolean result = yard.getGoat().moveBoxYourself(Direction.east());
        boolean exp = false;

        assertEquals(exp, !result);
    }


    @Test
    void canMovetoEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createBox(1,1);
        Box box = yard.getBox(0);

        boolean result = box.canMove(Direction.east());
        boolean exp = true;

        assertEquals(exp, result);
    }

    @Test
    void canMoveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,1, Direction.east());

        labyrinth.createBox(1,1);
        Box box = yard.getBox(0);

        boolean result = box.canMove(Direction.east());
        boolean exp = false;

        assertEquals(exp, result);
    }
}
