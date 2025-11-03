package game;

public class Wall {

    private final Yard _yard;

    public Wall(Yard yard) {
        _yard = yard;
    }

    private MiddlePosition _position;

    public MiddlePosition position() {
        return _position;
    }

    boolean setPosition(MiddlePosition pos) {
        if (!_yard.isWall(pos)) {
            _position = pos;
            return true;
        }
        return false;
    }

    // ----------------------- Методы класса -------------------------

    public static final int VERTICAL = 1;
    public static final int HORIZONTAL = 2;

    public int orientation() throws IllegalArgumentException {
        Direction direct = position().direction();

        if (direct.equals(Direction.south()) || direct.equals(Direction.north())) return VERTICAL;
        if (direct.equals(Direction.west()) || direct.equals(Direction.east())) return HORIZONTAL;

        else throw new IllegalArgumentException("Error: incorrect orientation");
    }
}
