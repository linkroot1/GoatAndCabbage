package game;

public class MiddlePosition {
    private CellPosition _cellPosition;
    private Direction _direction;

    public Direction direction() {
        return this._direction;
    }

    public CellPosition cellPosition() {
        return this._cellPosition;
    }

    public MiddlePosition(CellPosition cellPos, Direction direct) {
        if (!cellPos.isValid()) {
            throw new IllegalArgumentException("Error: CellPosition");
        } else {
            this._cellPosition = cellPos;
            this._direction = direct;
            this.normalize();
        }
    }

    private void normalize() {
        if (this._direction.equals(Direction.south()) && this._cellPosition.hasNext(this._direction)) {
            this._cellPosition = this._cellPosition.next(this._direction);
            this._direction = Direction.north();
        }

        if (this._direction.equals(Direction.east()) && this._cellPosition.hasNext(this._direction)) {
            this._cellPosition = this._cellPosition.next(this._direction);
            this._direction = Direction.west();
        }

    }

    public MiddlePosition clone() {
        return new MiddlePosition(this._cellPosition, this._direction);
    }

    public MiddlePosition next(Direction direct) {
        if (this._cellPosition.hasNext(direct)) {
            return new MiddlePosition(this._cellPosition.next(direct), this._direction);
        } else {
            return this._direction.isOpposite(direct) ? new MiddlePosition(this._cellPosition, this._direction.opposite()) : null;
        }
    }

    public boolean hasNext(Direction direct) {
        return this._cellPosition.hasNext(direct) || this._direction.isOpposite(direct);
    }

    public CellPosition cellPosition(Direction direct) {
        if (this._direction.isOpposite(direct)) {
            return this._cellPosition.clone();
        } else {
            return this._direction.equals(direct) && this._cellPosition.hasNext(direct) ? this._cellPosition.next(direct) : null;
        }
    }

    public boolean hasCellPosition(Direction direct) {
        return this._direction.isOpposite(direct) || this._cellPosition.hasNext(direct);
    }

    public boolean equals(Object other) {
        if (!(other instanceof MiddlePosition)) {
            return false;
        } else {
            MiddlePosition otherPosition = (MiddlePosition) other;
            return this._cellPosition.equals(otherPosition._cellPosition) && this._direction.equals(otherPosition._direction);
        }
    }

    public int hashCode() {
        return this._direction.hashCode() * this._cellPosition.hashCode();
    }
}