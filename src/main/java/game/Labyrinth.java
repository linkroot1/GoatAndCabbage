package game;

import game.moveObjects.Box;
import game.moveObjects.Goat;

public class Labyrinth {


    //-----------------------------------------Свойства класса-----------------------------------------------

    private Yard _yard;

    public Labyrinth(Yard _yard) {
        this._yard = _yard;
    }


    //------------------------------------------Методы класса-------------------------------------------------

    //Создать стену
    public void createWall( int row, int col, Direction direction ){


        _yard.addWall(new MiddlePosition(new CellPosition(row,col), direction), new Wall(_yard));
    }


    //Создать коробку
    public void createBox(int row, int col){

        _yard.addBox(new CellPosition(row, col), new Box(_yard));

    }



    //Создать ключ
    public  void  createKey(int row, int col){

        _yard.addKey(new CellPosition(row, col), new Key());

    }

    //Создать монетку
    public void createCoin( int row, int col ){


        _yard.addCoin(new CellPosition(row,col), new Coin(_yard));
    }


    //Создать козу
    public void createGoat(int row, int col, int energy){

        _yard.addGoat(new CellPosition(row, col), new Goat(energy));

    }


    //Создать капусту
    public void createCabbage(int row, int col){

        _yard.addCabbage(new CellPosition(row, col), new Cabbage(_yard));

    }


    //Получить загон
    public Yard get_yard() {
        return _yard;
    }


    //Задать загон
    public void set_yard(Yard _yard) {
        this._yard = _yard;
    }


    public void createTeleport(int row, int col) {
        _yard.addTeleport(new CellPosition(row, col), new Teleport(_yard));
    }
}
