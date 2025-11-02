package game;

import game.moveObjects.Box;
import game.moveObjects.Goat;

import java.util.ArrayList;

public class Yard {

    //--------------------------------------Свойства класса--------------------------------------

    private Teleport _teleport;
    private Goat _goat;
    private Cabbage _cabbage;
    private Game _game;
    private Key _key;
    public ArrayList<Coin> _coinPool = new ArrayList();
    public Coin coin(CellPosition pos){

        if(_coinPool.size() < 1) return null;
        for (Coin obj : _coinPool)
        {
            if(obj.position() != null && obj.position().equals(pos))  return obj;
        }

        return null;
    }
    private ArrayList<Wall> _wallPool = new ArrayList();

    private ArrayList<Box> _boxPool = new ArrayList();
    public Box box(CellPosition pos){

        for (Box obj : _boxPool)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }




    //--------------------------------------Конструктор класса----------------------------------------

    public Yard (int width, int height, Game game){

        _game = game;
        setSize(width, height);
    }

    public final void setSize(int width, int height) {
        CellPosition.setHorizontalRange(1, width);
        CellPosition.setVerticalRange(1, height);
    }

    public int width() {
        return CellPosition.horizontalRange().length();
    }

    public int height() {
        return CellPosition.verticalRange().length();
    }


    //--------------------------------------Методы класса----------------------------------------

    //Узнать что коза съела капусту и закончить игру с победой
    public void I_eat_cabbage(){

        _game.Win();
    }

    //Проверка на стену
    public boolean isWall(MiddlePosition pos){
        if (_wallScroll(pos) == null) return false;

        return true;
    }

    //Проверка на коробку
    public boolean isBox(CellPosition pos){
        if (boxScroll(pos) == null) return false;

        return true;
    }

    //Добавить стену
    public boolean addWall(MiddlePosition pos, Wall obj){

        boolean success = obj.setPosition(pos);

        if(success) _wallPool.add(obj);

        return success;
    }

    //Перебрать стены
    private Wall _wallScroll(MiddlePosition pos)
    {
        for (Wall obj : _wallPool)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }

    public void addCabbage(CellPosition pos, Cabbage cabbage){

        if (cabbage == null) throw new IllegalArgumentException("Cabbage is null ");

        if (cabbage != _cabbage)
        {
            _cabbage = cabbage;
            _cabbage.set_yard(this);
            _cabbage.setPosition(pos);
        }

    }

    public void addGoat(CellPosition pos, Goat goat ){

        if (goat == null) throw new IllegalArgumentException("moveObjects.Goat is null ");

        if (goat != _goat)
        {
            _goat = goat;
            _goat.set_yard(this);
            _goat.setPosition(pos);
        }

    }

    public void addCoin(CellPosition pos, Coin obj){

        obj.set_position(pos);
        _coinPool.add(obj);


    }

    public void addKey(CellPosition pos, Key key ){

        if (key == null) throw new IllegalArgumentException("key is null ");

        if (key != _key)
        {
            _key = key;
            _key.set_yard(this);
            _key.set_position(pos);
        }

    }



    //Добавить коробку
    public void addBox(CellPosition pos, Box obj){


        obj.setPosition(pos);
        _boxPool.add(obj);

    }


    //Перебрать коробки
    private Box boxScroll(CellPosition pos)
    {
        for (Box obj : _boxPool)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }

    //Перебрать коробки
    private Coin coinScroll(CellPosition pos)
    {
        for (Coin obj : _coinPool)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }



    //Проверить наличие козы и капусты в загоне
    public boolean existenceGoatCabbage(){

        return _cabbage != null && _goat != null;
    }


    //Получить козу
    public Goat getGoat() {
        if(_goat == null || _goat.isDestroy()) return null;
        return _goat;
    }


    //Получить капусту
    public Cabbage getCabbage() {
        if(_cabbage == null || _cabbage.isDestroy()) return null;
        return _cabbage;
    }






    //Получить клетку по индексу
    public Box getBox(int index ){

        return _boxPool.get(index);
    }

    //Получить клетку по индексу
    public Coin getCoin(int index ){

        return _coinPool.get(index);
    }



    public Key get_key() {
        return _key;
    }

    public void set_key(Key _key) {
        this._key = _key;
    }

    public Teleport get_teleport() {
        return _teleport;
    }

    public void addTeleport(CellPosition pos, Teleport teleport) {
        if (teleport == null) throw new IllegalArgumentException("teleport is null ");

        if (teleport != _teleport)
        {
            _teleport = teleport;
            _teleport.set_yard(this);
            _teleport.set_position(pos);
        }
    }
}
