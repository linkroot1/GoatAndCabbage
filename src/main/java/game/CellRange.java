package game;

public class CellRange {
    private int _min = 0;
    private int _max = 0;

    public CellRange(int min, int max) {
        if (min < 0) {
            min = 0;
        }

        if (max < min) {
            max = min;
        }

        this._min = min;
        this._max = max;
    }

    public int min() {
        return this._min;
    }

    public int max() {
        return this._max;
    }

    public int length() {
        return this._max - this._min + 1;
    }

    public static boolean isValidRange(int min, int max) {
        return min > 0 && max >= min;
    }

    public boolean contains(int val) {
        return val >= this._min && val <= this._max;
    }
}
