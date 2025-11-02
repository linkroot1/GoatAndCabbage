package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WallTest {

    @Test
    void position() {
        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.east()), wall);

        boolean exp = true;
        boolean result = wall.position().equals(new MiddlePosition(new CellPosition(1,2), Direction.east().opposite()));

        assertEquals(exp, result);
    }

    @Test
    void orientation1() {
        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.north()), wall);

        boolean exp = true;
        boolean result = wall.orientation() == 1;

        assertEquals(exp, result);
    }

    @Test
    void orientation2() {
        Yard yard = new Yard(5,5,new Game());

        Wall wall = new Wall(yard);
        yard.addWall(new MiddlePosition(new CellPosition(1,1), Direction.east()), wall);

        boolean exp = true;
        boolean result = wall.orientation() == 2;

        assertEquals(exp, result);
    }
}
