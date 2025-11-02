package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YardTest {

    @Test
    void existenceGoatCabbageAfterCreate() {;
        Game game = new Game();
        Yard yard = new Yard(4,4, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createCabbage(1,1);
        labyrinth.createGoat(1, 2, 100);

        boolean exp = true;
        boolean result = yard.existenceGoatCabbage();

        assertEquals(exp, result);
    }

    @Test
    void existenceGoatCabbageBeforeCreate() {
        Game game = new Game();
        Yard yard = new Yard(3,3, game);


        boolean exp = true;
        boolean result = !yard.existenceGoatCabbage();

        assertEquals(exp, result);
    }
}
