package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void initGame() {

        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        game.initGame();

        if(game.findGoatAndCabbageInYard() && !game.checkGameEnding()) result = true;

        assertEquals(result, exp);

    }

    @Test
    void checkGameEndingAfterInitBeforeEnd() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        game.initGame();

        if(!game.checkGameEnding()) result = true;

        assertEquals(result, exp);
    }

    @Test
    void checkGameEndingAfterEnd() {
        boolean result = false;
        boolean exp = false;

        Game game = new Game();
        game.initGame();
        game.stopGame();

        if(!game.checkGameEnding()) result = true;

        assertEquals(result, exp);
    }

    @Test
    void checkGameEndingBeforeInit() {
        boolean result = false;
        boolean exp = false;

        Game game = new Game();


        if(!game.checkGameEnding()) result = true;

        assertEquals(result, exp);
    }


    @Test
    void determinateWin() {
        boolean result = false;
        boolean exp = false;

        Game game = new Game();
        game.initGame();

        result = game.determinateWin();

        assertEquals(result, exp);


    }

    @Test
    void findGoatAndCabbageInYardAffterInit() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        game.initGame();

        result = game.findGoatAndCabbageInYard();

        assertEquals(result, exp);

    }

    @Test
    void findGoatAndCabbageInYardBeforeInit() {
        boolean result = false;
        boolean exp = false;

        Game game = new Game();


        result = game.findGoatAndCabbageInYard();

        assertEquals(result, exp);

    }


}