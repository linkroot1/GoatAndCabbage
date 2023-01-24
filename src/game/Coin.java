package game;

public class Coin implements collectedObject{

    private CellPosition _position;
    private Yard _yard;

    public Coin(Yard _yard) {
        this._yard = _yard;
    }


    public CellPosition position() {
        return _position;
    }

    public void set_position(CellPosition _position) {
        this._position = _position;
    }

    public Yard get_yard() {
        return _yard;
    }

    public void set_yard(Yard _yard) {
        this._yard = _yard;
    }
}
