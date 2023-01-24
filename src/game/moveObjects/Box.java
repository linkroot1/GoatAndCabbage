package game.moveObjects;

import game.CellPosition;
import game.Direction;
import game.MiddlePosition;
import game.Yard;


public class Box implements movableObjects {


    //----------Свойства класса-----------------

    private CellPosition _position;
    private Yard _yard;


    //----------Конструктор класса--------------------

    public Box(Yard _yard) {
        this._yard = _yard;
    }


    //----------Методы класса--------------------

    //Переместиться
    boolean move(Direction direction){

        if (this.canMove(direction)) {
            this.setPosition(this.position().next(direction));
            return true;
        }
        return false;
    }


    //Проверить можно ли переместиться
    public boolean canMove(Direction direction){

        //Проверяем есть ли следующая позиция
        if (!this.position().hasNext(direction)) return false;


        // Проверяем есть ли стена
        MiddlePosition nextMiddlePos = new MiddlePosition(this.position(), direction);
        CellPosition nextCellPos = this.position().next(direction);
        if (this._yard.isWall(nextMiddlePos)) return false;


            //Проверяем есть ли коробка
        else if (this._yard.isBox(nextCellPos)) return false;


        return true;
    }





    public boolean setPosition(CellPosition pos){
        _position = pos;
        return true;
    }

    public CellPosition position(){
        return _position;
    }
}
