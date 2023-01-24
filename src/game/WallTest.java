package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WallTest {

    @Test
    void position() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.east()), wall);

        result = wall.position().equals(new MiddlePosition(new CellPosition(1,2), Direction.east().opposite()));

        assertEquals(exp, result);

    }

    @Test
    void orientation1() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.north()), wall);


        if (wall.orientation() == 1) result = true;

        assertEquals(exp, result);
    }

    @Test
    void orientation2() {
        boolean exp = true;
        boolean result = false;

        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.east()), wall);


        if (wall.orientation() == 2) result = true;

        assertEquals(exp, result);
    }
}