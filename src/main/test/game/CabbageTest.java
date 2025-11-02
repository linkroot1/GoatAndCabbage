package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CabbageTest {

    @Test
    void destroy() {
        Game game = new Game();
        Yard yard = new Yard(4,4, game);
        Cabbage cabbage = new Cabbage(yard);
        cabbage.destroy();

        boolean exp = true;
        boolean result = cabbage.isDestroy();

        assertEquals(exp, result);
    }

    @Test
    void NotDestroy() {
        Game game = new Game();
        Yard yard = new Yard(4,4, game);
        Cabbage cabbage = new Cabbage(yard);

        boolean exp = true;
        boolean result = !(cabbage.isDestroy());

        assertEquals(exp, result);
    }

    @Test
    void position() {
        Game game = new Game();
        Yard yard = new Yard(4,4, game);
        Cabbage cabbage = new Cabbage(yard);
        cabbage.setPosition(new CellPosition(1,1));

        boolean exp = true;
        boolean result = cabbage.position().equals(new CellPosition(1, 1));

        assertEquals(exp, result);
    }
}
