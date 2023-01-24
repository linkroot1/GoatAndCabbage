package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YardTest {

    @Test
    void existenceGoatCabbageAfterCreate() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(4,4, game);
        Labyrinth labyrinth = new Labyrinth(yard);

        labyrinth.createCabbage(1,1);
        labyrinth.createGoat(1, 2, 100);

        result = yard.existenceGoatCabbage();
        assertEquals(result, exp);
    }

    @Test
    void existenceGoatCabbageBeforeCreate() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(3,3, game);


        result = !yard.existenceGoatCabbage();
        assertEquals(result, exp);
    }
}