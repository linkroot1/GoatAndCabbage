package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void initGame() {
        Game game = new Game();
        game.initGame();

        boolean exp = true;
        boolean result = game.findGoatAndCabbageInYard() && !game.checkGameEnding();

        assertEquals(exp, result);
    }

    @Test
    void checkGameEndingAfterInitBeforeEnd() {
        Game game = new Game();
        game.initGame();

        boolean exp = true;
        boolean result = !game.checkGameEnding();

        assertEquals(exp, result);
    }

    @Test
    void checkGameEndingAfterEnd() {
        Game game = new Game();
        game.initGame();
        game.stopGame();

        boolean exp = false;
        boolean result = !game.checkGameEnding();

        assertEquals(exp, result);
    }

    @Test
    void checkGameEndingBeforeInit() {
        Game game = new Game();

        boolean exp = false;
        boolean result = !game.checkGameEnding();

        assertEquals(exp, result);
    }

    @Test
    void determinateWin() {
        Game game = new Game();
        game.initGame();

        boolean exp = false;
        boolean result = game.determinateWin();

        assertEquals(exp, result);
    }

    @Test
    void findGoatAndCabbageInYardAfterInit() {
        Game game = new Game();
        game.initGame();

        boolean exp = true;
        boolean result = game.findGoatAndCabbageInYard();

        assertEquals(exp, result);
    }

    @Test
    void findGoatAndCabbageInYardBeforeInit() {
        Game game = new Game();

        boolean exp = false;
        boolean result = game.findGoatAndCabbageInYard();

        assertEquals(exp, result);
    }
}
