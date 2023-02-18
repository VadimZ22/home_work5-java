package home_work5;

public class Point {
    private int i;
    private int j;
    private int value;
//    Point up;
//    Point right;
//    Point down;
//    Point left;

    public Point(int i, int j, int[][] map) {
        this.i = i;
        this.j = j;
        this.value = map[i][j];
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
