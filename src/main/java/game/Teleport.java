package game;

import game.moveObjects.Goat;

import java.util.Random;

public class Teleport {


    //--------------------------------------Свойства класса--------------------------------------

    private CellPosition _position;
    private Yard _yard;

    //--------------------------------------Конструктор класса----------------------------------------

    public Teleport(Yard _yard) {
        this._yard = _yard;
    }

    //--------------------------------------Методы класса----------------------------------------

    //Активироваться
    public boolean activate(Goat goat) {
        CellPosition resultPos;
        boolean posInvalid = true;
        int rowMax = _yard.width();
        int colMax = _yard.height();
        final Random random = new Random();

        do {
            resultPos = new CellPosition(random.nextInt(rowMax - 1) + 1, random.nextInt(colMax - 1) + 1);

            if (!_yard.isBox(resultPos)) {
                goat.setPosition(resultPos);
                goat.fireGoatAction();
                goat.eatCabbage();
                if (goat.get_key() == null) goat.takeKey();
                posInvalid = false;
            }

        } while (posInvalid);

        return true;
    }

    public CellPosition position() {
        return _position;
    }

    public void set_position(CellPosition _position) {
        this._position = _position;
    }

    public void set_yard(Yard _yard) {
        this._yard = _yard;
    }
}
