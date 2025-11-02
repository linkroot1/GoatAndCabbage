package game;

import game.moveObjects.Goat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoatTest {

    @Test
    void getEnergy() {
        Goat goat = new Goat(8);

        boolean exp = true;
        boolean result = goat.getEnergy() == 8;

        assertEquals(exp, result);
    }

    @Test
    void moveToEmptyCell() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 100);
        Goat goat = yard.getGoat();
        labyrinth.createCabbage(2,2);

        boolean result_after_move = goat.move(Direction.east());
        CellPosition newPosition = new CellPosition(1,2);
        boolean result_position = goat.position().equals(newPosition);
        boolean result = result_after_move && result_position;
        boolean exp = true;

        assertEquals(exp, result);
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

        assertEquals(exp, result);
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

        assertEquals(exp, result);
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

        assertEquals(exp, result);
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

        assertEquals(exp, result);
    }

    @Test
    void expendEnergy() {
        Game game = new Game();
        Yard yard = new Yard(3,2, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1,1, 8);
        labyrinth.createCabbage(2,2);
        Goat goat = yard.getGoat();
        goat.move(Direction.south());

        boolean exp = true;
        boolean result = goat.getEnergy() == 7;

        assertEquals(exp, result);
    }

    @Test
    void eatCabbage() {
        Game game = new Game();
        Yard yard = new Yard(2,3, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(1, 1, 100);
        labyrinth.createCabbage(2, 1);

        yard.getGoat().move(Direction.south());

        boolean exp = true;
        boolean result = yard.getGoat().eatCabbage();

        assertEquals(exp, result);
    }

    @Test
    void moveBoxYourselfUp() {
        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 1, 100);
        labyrinth.createBox(4, 1);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxYourself(Direction.north());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(3,1)) != null && yard.getGoat().position().equals(new CellPosition(2,1));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxYourselfDown() {
        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(4, 1, 100);
        labyrinth.createBox(3, 1);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxYourself(Direction.south());
        boolean exp = true;
        boolean result = yard.box(new CellPosition(4, 1)) != null && yard.getGoat().position().equals(new CellPosition(5, 1));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxYourselfLeft() {
        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 2, 100);
        labyrinth.createBox(3, 3);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxYourself(Direction.west());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(3, 2)) != null && yard.getGoat().position().equals(new CellPosition(3, 1));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxYourselfRight() {
        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 3, 100);
        labyrinth.createBox(3, 2);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxYourself(Direction.east());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(3, 3)) != null && yard.getGoat().position().equals(new CellPosition(3, 4));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxAwayFromYouDown() {
        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(2, 1, 100);
        labyrinth.createBox(3, 1);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxAwayFromYou(Direction.south());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(4, 1)) != null && yard.getGoat().position().equals(new CellPosition(3, 1));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxAwayFromYouUp() {
        Game game = new Game();
        Yard yard = new Yard(5,5, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 1, 100);
        labyrinth.createBox(2, 1);
        labyrinth.createCabbage(4,4);

        yard.getGoat().moveBoxAwayFromYou(Direction.north());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(1, 1)) != null && yard.getGoat().position().equals(new CellPosition(2, 1));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxAwayFromYouLeft() {
        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 4, 100);
        labyrinth.createBox(3, 3);
        labyrinth.createCabbage(5,5);

        yard.getGoat().moveBoxAwayFromYou(Direction.west());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(3, 2)) != null && yard.getGoat().position().equals(new CellPosition(3, 3));

        assertEquals(exp, result);
    }

    @Test
    void moveBoxAwayFromYouRight() {
        Game game = new Game();
        Yard yard = new Yard(6,6, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createGoat(3, 3, 100);
        labyrinth.createBox(3, 4);
        labyrinth.createCabbage(5,5);

        yard.getGoat().moveBoxAwayFromYou(Direction.east());

        boolean exp = true;
        boolean result = yard.box(new CellPosition(3, 5)) != null && yard.getGoat().position().equals(new CellPosition(3, 4));

        assertEquals(exp, result);
    }

    @Test
    void destroy() {
        Goat goat = new Goat(9);
        goat.destroy();

        boolean exp = true;
        boolean result = goat.isDestroy();

        assertEquals(exp, result);
    }

    @Test
    void isDestroy() {
        Goat goat = new Goat(9);

        boolean exp = true;
        boolean result = !goat.isDestroy();

        assertEquals(exp, result);
    }

    @Test
    void takeKey() {
        Game game = new Game();
        Yard yard = new Yard(6,6,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createCabbage(5,5);
        labyrinth.createKey(1,1);
        labyrinth.createGoat(1,1, 8);

        boolean exp = true;
        boolean result = yard.getGoat().takeKey();

        if (yard.getGoat().get_key() == null) result = false;

        assertEquals(exp, result);
    }

    @Test
    void useKey() {
        Game game = new Game();
        Yard yard = new Yard(6,6,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createCabbage(5,5);
        labyrinth.createKey(1,1);
        labyrinth.createGoat(1,1, 8);
        labyrinth.createTeleport(1,2);

        yard.getGoat().takeKey();
        yard.getGoat().move(Direction.east());

        boolean exp = true;
        boolean result = yard.getGoat().useKey();
        if(yard.getGoat().position().equals(new CellPosition(1,2))) {
            yard.getGoat().useKey();
            if(yard.getGoat().position().equals(new CellPosition(1,2))){
                yard.getGoat().useKey();
                if(yard.getGoat().position().equals(new CellPosition(1,2))){
                    result = false;
                }
            }
        }

        assertEquals(exp, result);
    }
}
