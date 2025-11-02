package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {


    @Test
    void testClone() {
        Direction direction = Direction.east();
        Direction newDirection = direction.clone();

        boolean exp = true;
        boolean result = direction.equals(newDirection);

        assertEquals(exp, result);
    }

    @Test
    void clockwise() {
        Direction direction = Direction.south();
        Direction newDirection = direction.clockwise();

        boolean exp = true;
        boolean result = newDirection.equals(Direction.west());

        assertEquals(exp, result);
    }

    @Test
    void anticlockwise() {
        Direction direction = Direction.west();
        Direction newDirection = direction.anticlockwise();

        boolean exp = true;
        boolean result = newDirection.equals(Direction.south());

        assertEquals(exp, result);
    }

    @Test
    void opposite() {
        Direction direction = Direction.west();
        Direction newDirection = direction.opposite();

        boolean exp = true;
        boolean result = newDirection.equals(Direction.east());

        assertEquals(exp, result);
    }

    @Test
    void rightWord() {
        Direction direction = Direction.south();
        Direction newDirection = direction.rightword();

        boolean exp = true;
        boolean result = newDirection.equals(Direction.west());

        assertEquals(exp, result);
    }

    @Test
    void leftWord() {
        Direction direction = Direction.west();
        Direction newDirection = direction.leftword();

        boolean exp = true;
        boolean result = newDirection.equals(Direction.south());

        assertEquals(exp, result);
    }

    @Test
    void testEquals() {
        Direction direction = Direction.west();
        Direction newDirection = Direction.west();

        boolean exp = true;
        boolean result = newDirection.equals(direction);

        assertEquals(exp, result);
    }

    @Test
    void isOpposite() {
        Direction direction = Direction.west();
        Direction newDirection = Direction.east();

        boolean exp = true;
        boolean result = direction.isOpposite(newDirection);

        assertEquals(exp, result);
    }
}
