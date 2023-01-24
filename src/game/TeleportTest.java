package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeleportTest {

    @Test
    void activate() {
        boolean result = false;
        boolean exp = true;

        Game game = new Game();
        Yard yard = new Yard(6,6,game);
        Labyrinth labyrinth = new Labyrinth(yard);
        labyrinth.createCabbage(5,5);
        labyrinth.createKey(1,1);
        labyrinth.createGoat(1,1, 8);
        labyrinth.createTeleport(1,2);

        yard.getGoat().takeKey();
        yard.getGoat().move(Direction.east());
        result = yard.get_teleport().activate(yard.getGoat());

        if(yard.getGoat().position().equals(new CellPosition(1,2))) {
            yard.get_teleport().activate(yard.getGoat());
            if(yard.getGoat().position().equals(new CellPosition(1,2))){
                yard.get_teleport().activate(yard.getGoat());
                if(yard.getGoat().position().equals(new CellPosition(1,2))){
                    result = false;
                }
            }
        }

        assertEquals(result, exp);
    }
}