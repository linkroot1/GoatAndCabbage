package game;

import java.util.HashMap;


public class CellPosition {
    private static CellRange _horizontalRange = new CellRange(0, 0);
    private static CellRange _verticalRange = new CellRange(0, 0);
    private final int _row;
    private final int _column;

    public static void setHorizontalRange(int min, int max) {
        if (CellRange.isValidRange(min, max)) {
            _horizontalRange = new CellRange(min, max);
        }
    }

    public static CellRange horizontalRange() {
        return _horizontalRange;
    }

    public static void setVerticalRange(int min, int max) {
        if (CellRange.isValidRange(min, max)) {
            _verticalRange = new CellRange(min, max);
        }
    }

    public static CellRange verticalRange() {
        return _verticalRange;
    }

    public CellPosition(int row, int col) {
        if (!isValid(row, col)) {
            throw new IllegalArgumentException("Error: Incorrect row or col");
        } else {
            this._row = row;
            this._column = col;
        }
    }

    public int row() {
        if (!this.isValid()) {
            throw new IllegalArgumentException("Error: incorrect row");
        } else {
            return this._row;
        }
    }

    public int column() {
        if (!this.isValid()) {
            throw new IllegalArgumentException("Error: incorrect col");
        } else {
            return this._column;
        }
    }

    public boolean isValid() {
        return isValid(this._row, this._column);
    }

    public static boolean isValid(int row, int col) {
        return _horizontalRange.contains(col) && _verticalRange.contains(row);
    }

    public CellPosition clone() {
        return new CellPosition(this._row, this._column);
    }

    public CellPosition next(Direction direct) {
        int[] newPos = this.calcNewPosition(this._row, this._column, direct);
        return new CellPosition(newPos[0], newPos[1]);
    }

    public boolean hasNext(Direction direct) {
        int[] newPos = this.calcNewPosition(this._row, this._column, direct);
        return isValid(newPos[0], newPos[1]);
    }

    private int[] calcNewPosition(int row, int col, Direction direct) {
        HashMap<Direction, int[]> offset = new HashMap<>();
        offset.put(Direction.north(), new int[]{0, -1});
        offset.put(Direction.south(), new int[]{0, 1});
        offset.put(Direction.east(), new int[]{1, 0});
        offset.put(Direction.west(), new int[]{-1, 0});
        return new int[]{this._row + ((int[]) offset.get(direct))[1], this._column + ((int[]) offset.get(direct))[0]};
    }

    public boolean equals(Object other) {
        if (!this.isValid()) {
            throw new IllegalArgumentException("Error: is not valid");
        } else if (!(other instanceof CellPosition)) {
            return false;
        } else {
            CellPosition otherPosition = (CellPosition) other;
            return this._row == otherPosition._row && this._column == otherPosition._column;
        }
    }
}

