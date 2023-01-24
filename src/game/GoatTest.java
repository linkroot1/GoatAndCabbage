package game;

import game.moveObjects.Goat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoatTest {

    @Test
    void getEnergy() {

        boolean result = false;
        boolean exp = true;

        Goat goat = new Goat(8);

        if (goat.getEnergy() == 8) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveToEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        labyrinth.createCabbage(2,2);
        boolean result = false;
        boolean result_after_move = goat.move(Direction.east());
        boolean result_position = false;
        CellPosition newPosition = new CellPosition(1,2);
        if(goat.position().equals(newPosition)) result_position =true;
        if(result_after_move && result_position) result = true;
        boolean exp = true;

        assertEquals(result, exp);

    }

    @Test
    void moveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,1, Direction.east());


        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        boolean result = goat.move(Direction.east());
        boolean exp = false;

        assertEquals(result, exp);

    }


    @Test
    void canMovetoEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        boolean result = goat.canMove(Direction.east());
        boolean exp = true;

        assertEquals(result, exp);

    }

    @Test
    void canMoveToWallInCurrentCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,1, Direction.east());

        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        boolean result = goat.canMove(Direction.east());
        boolean exp = false;

        assertEquals(result, exp);

    }

    @Test
    void canMoveToWallInNextCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createWall(1,2, Direction.west());

        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        boolean result = goat.canMove(Direction.east());
        boolean exp = false;

        assertEquals(result, exp);

    }

    @Test
    void expendEnergy() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 8);
        labyrinth.createCabbage(2,2);
        Goat goat = yard.getGoat();
        goat.move(Direction.south());

        if ( goat.getEnergy() == 7) result = true;

        assertEquals(result, exp);


    }

    @Test
    void eatCabbage() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(2,3, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1, 1, 100);
        labyrinth.createCabbage(2, 1);

        yard.getGoat().move(Direction.south());
        result = yard.getGoat().eatCabbage();

        assertEquals(result, exp);

    }

    @Test
    void moveBoxYourselfUp() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 1, 100);
        labyrinth.createBox(4, 1);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(4,1);
        yard.getGoat().moveBoxYourself(Direction.north());
        if(yard.box(new CellPosition(3,1)) != null && yard.getGoat().position().equals(new CellPosition(2,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxYourselfDown() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(4, 1, 100);
        labyrinth.createBox(3, 1);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(3,1);
        yard.getGoat().moveBoxYourself(Direction.south());
        if(yard.box(new CellPosition(4,1)) != null && yard.getGoat().position().equals(new CellPosition(5,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxYourselfLeft() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 2, 100);
        labyrinth.createBox(3, 3);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(4,1);
        yard.getGoat().moveBoxYourself(Direction.west());
        if(yard.box(new CellPosition(3,2)) != null && yard.getGoat().position().equals(new CellPosition(3,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxYourselfRight() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 3, 100);
        labyrinth.createBox(3, 2);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(4,1);
        yard.getGoat().moveBoxYourself(Direction.east());
        if(yard.box(new CellPosition(3,3)) != null && yard.getGoat().position().equals(new CellPosition(3,4))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxAwayFromYouDown() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(2, 1, 100);
        labyrinth.createBox(3, 1);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(3,1);
        yard.getGoat().moveBoxAwayFromYou(Direction.south());
        if(yard.box(new CellPosition(4,1)) != null && yard.getGoat().position().equals(new CellPosition(3,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxAwayFromYouUp() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 1, 100);
        labyrinth.createBox(2, 1);
        labyrinth.createCabbage(4,4);

        CellPosition pos = new CellPosition(3,1);
        yard.getGoat().moveBoxAwayFromYou(Direction.north());
        if(yard.box(new CellPosition(1,1)) != null && yard.getGoat().position().equals(new CellPosition(2,1))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxAwayFromYouLeft() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 4, 100);
        labyrinth.createBox(3, 3);
        labyrinth.createCabbage(5,5);

        CellPosition pos = new CellPosition(3,1);
        yard.getGoat().moveBoxAwayFromYou(Direction.west());
        if(yard.box(new CellPosition(3,2)) != null && yard.getGoat().position().equals(new CellPosition(3,3))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void moveBoxAwayFromYouRight() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 3, 100);
        labyrinth.createBox(3, 4);
        labyrinth.createCabbage(5,5);

        CellPosition pos = new CellPosition(3,1);
        yard.getGoat().moveBoxAwayFromYou(Direction.east());
        if(yard.box(new CellPosition(3,5)) != null && yard.getGoat().position().equals(new CellPosition(3,4))) result = true;

        assertEquals(result, exp);
    }

    @Test
    void destroy() {
        boolean result = false;
        boolean exp = true;

        Goat goat = new Goat(9);
        goat.destroy();

        result = goat.isDestroy();

        assertEquals(result, exp);

    }

    @Test
    void isDestroy() {
        boolean result = false;
        boolean exp = true;

        Goat goat = new Goat(9);


        result = !goat.isDestroy();

        assertEquals(result, exp);
    }

    @Test
    void takekey() {

        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createCabbage(5,5);
        labyrinth.createKey(1,1);
        labyrinth.createGoat(1,1, 8);

        result = yard.getGoat().takeKey();

        if(yard.getGoat().get_key() == null) result = false;

        assertEquals(result, exp);
    }

    @Test
    void usekey() {

        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createCabbage(5,5);
        labyrinth.createKey(1,1);
        labyrinth.createGoat(1,1, 8);
        labyrinth.createTeleport(1,2);

        yard.getGoat().takeKey();
        yard.getGoat().move(Direction.east());
        result = yard.getGoat().useKey();
        if(yard.getGoat().position().equals(new CellPosition(1,2))) {
            yard.getGoat().useKey();
            if(yard.getGoat().position().equals(new CellPosition(1,2))){
                yard.getGoat().useKey();
                if(yard.getGoat().position().equals(new CellPosition(1,2))){
                    result = false;
                }
            }
        }

        assertEquals(result, exp);
    }
}