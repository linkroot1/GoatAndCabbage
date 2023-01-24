package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {


    @Test
    void testClone() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.east();
        Direction newDirection = direction.clone();

        if(direction.equals(newDirection)) result = true;

        assertEquals(exp, result);

    }

    @Test
    void clockwise() {

        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.south();
        Direction newDirection = direction.clockwise();

        if(newDirection.equals(Direction.west())) result = true;

        assertEquals(exp, result);

    }

    @Test
    void anticlockwise() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.west();
        Direction newDirection = direction.anticlockwise();

        if(newDirection.equals(Direction.south())) result = true;

        assertEquals(exp, result);
    }

    @Test
    void opposite() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.west();
        Direction newDirection = direction.opposite();

        if(newDirection.equals(Direction.east())) result = true;

        assertEquals(exp, result);
    }

    @Test
    void rightword() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.south();
        Direction newDirection = direction.rightword();

        if(newDirection.equals(Direction.west())) result = true;

        assertEquals(exp, result);
    }

    @Test
    void leftword() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.west();
        Direction newDirection = direction.leftword();

        if(newDirection.equals(Direction.south())) result = true;

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.west();
        Direction newDirection = Direction.west();

        if(newDirection.equals(direction)) result = true;

        assertEquals(exp, result);
    }

    @Test
    void isOpposite() {
        boolean exp = true;
        boolean result = false;

        Direction direction = Direction.west();
        Direction newDirection = Direction.east();

        result = direction.isOpposite(newDirection);

        assertEquals(exp, result);

    }
}