package game;

public class Cabbage {

    //----------Свойства класса-----------------

    private Yard _yard;
    private CellPosition _position;
    private boolean destroy = false;

    public Cabbage(Yard _yard) {
        this._yard = _yard;

    }


    //----------Методы класса--------------------

    //Получить загон
    public Yard get_yard() {
        return _yard;
    }


    //Уничтожить
    public void destroy() {
        destroy = true;
    }

    //Уничтожена ли капуста?
    public boolean isDestroy() {
        return destroy;
    }


    //Задать загон
    public void set_yard(Yard _yard) {
        this._yard = _yard;
    }

    protected boolean setPosition(CellPosition pos){
        _position = pos;
        return true;
    }

    public CellPosition position(){
        if(this == null) return null;
        return _position;
    }

}
