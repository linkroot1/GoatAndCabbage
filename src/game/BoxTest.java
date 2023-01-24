package game;

import game.moveObjects.Box;
import game.moveObjects.Goat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoxTest {

    @org.junit.jupiter.api.Test
    void moveToEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);

        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createBox(1,1);
        labyrinth.createCabbage(2,2);

        Box box = yard.getBox(0);
        labyrinth.createGoat(1,2,10);


        boolean result = yard.getGoat().moveBoxYourself(Direction.east());
        boolean exp = true;

        assertEquals(result, exp);

    }

    @org.junit.jupiter.api.Test
    void moveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,1, Direction.east());
        labyrinth.createCabbage(2,2);
        labyrinth.createGoat(1,2,10);


        labyrinth.createBox(1,1);
        Box box = yard.getBox(0);
        boolean result = yard.getGoat().moveBoxYourself(Direction.east());
        boolean exp = false;

        assertEquals(!result, exp);

    }


    @org.junit.jupiter.api.Test
    void canMovetoEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createBox(1,1);
        Box box = yard.getBox(0);
        boolean result = box.canMove(Direction.east());
        boolean exp = true;

        assertEquals(result, exp);

    }

    @org.junit.jupiter.api.Test
    void canMoveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,1, Direction.east());

        labyrinth.createBox(1,1);
        Box box = yard.getBox(0);
        boolean result = box.canMove(Direction.east());
        boolean exp = false;

        assertEquals(result, exp);

    }



}