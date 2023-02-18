package home_work5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        int[][] map = getMap();

        Deque<Point> elements = new ArrayDeque<>();
        start(map, 5, 0);
        finish(map, 0, 7);
        finish(map, 9, 7);
        Point start = new Point(5, 0, map);
        pprint(map);
        elements.addLast(start);
        setValues(elements, map); // Заполнение карты значениями
        System.out.println("------------------------------------");
        pprint(map);
        Point finish1 = new Point(0,7,map);
        Point finish2 = new Point(9,7,map);
        System.out.println(finish1.getValue()); // количество шагов до первого выхода
        System.out.println(finish2.getValue()); // количество шагов до второго выхода
        System.out.println("------------------------------------");
        findRoute(finish1, map); //построение маршрута
        findRoute(finish2, map);
        pprint(map);

    }

    //функция заполнения карты.
    private static void setValues(Deque<Point> elements, int[][] map) {
        while (!elements.isEmpty()){
            Point e = elements.removeFirst();
            //System.out.println(e.getValue());
            try {
                Point up = new Point(e.getI() - 1, e.getJ(), map);
                if (up.getValue() == 0 || up.getValue() == -2){
                    up.setValue(e.getValue()+1);
                    map[up.getI()][up.getJ()] = up.getValue();
                    elements.addLast(up);
                }
            } catch (Exception ex) {
                //System.out.println(ex);
            }
            try {
                Point right = new Point(e.getI(), e.getJ() + 1, map);
                if (right.getValue() == 0 || right.getValue() == -2){
                    right.setValue(e.getValue()+1);
                    map[right.getI()][right.getJ()] = right.getValue();
                    elements.addLast(right);
                }
            } catch (Exception ex) {
                //System.out.println(ex);
            }
            try {
                Point down = new Point(e.getI() + 1, e.getJ(), map);
                if (down.getValue() == 0 || down.getValue() == -2){
                    down.setValue(e.getValue()+1);
                    map[down.getI()][down.getJ()] = down.getValue();
                    elements.addLast(down);
                }
            } catch (Exception ex) {
                //System.out.println(ex);
            }
            try {
                Point left = new Point(e.getI(), e.getJ()-1, map);
                if (left.getValue() == 0 || left.getValue() == -2){
                    left.setValue(e.getValue()+1);
                    map[left.getI()][left.getJ()] = left.getValue();
                    elements.addLast(left);
                }
            } catch (Exception ex) {
                //System.out.println(ex);
            }

        }
    }

    //функция строит маршрут, помечая его нулями на карте.
    static void findRoute(Point p, int[][] map){
        Deque<Point> route = new ArrayDeque<>();
        route.add(p);
        while (!route.isEmpty()){
            Point e = route.removeLast();
            Point next = nexpPoint(e, map);
            map[e.getI()][e.getJ()] = 0;
            route.addLast(next);
            if (next.getValue() == 1) break;
        }

    }

    //функция выбирает следующую точку при построении маршрута.
    private static Point nexpPoint(Point e, int[][] map) {
        try {
            Point up = new Point(e.getI() - 1, e.getJ(), map);
            if (e.getValue() - up.getValue() == 1){
                return up;
            }
        } catch (Exception ex) {}

        try {
            Point right = new Point(e.getI(), e.getJ() + 1, map);
            if (e.getValue() - right.getValue() == 1){
                return right;
            }
        } catch (Exception ex) {}

        try {
            Point down = new Point(e.getI() + 1, e.getJ(), map);
            if (e.getValue() - down.getValue() == 1){
                return down;
            }
        } catch (Exception ex) {}

        try {
            Point left = new Point(e.getI(), e.getJ()-1, map);
            if (e.getValue() - left.getValue() == 1){
                return left;
            }
        } catch (Exception ex) {}

        return null;
    }

    static int[][] getMap() {
        return new int[][] {
                { 00, 00, 00, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, -1, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, -1, -1, -1, -1, -1, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, 00, 00 }
        };
    }

    static void pprint(int[][] m) {
        int rows = m.length;
        int colums = m[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (m[i][j] == -1)
                    System.out.printf("%s", "  @ ");
                else if (m[i][j] == 1)
                    System.out.printf("%s", "   1");
                else if (m[i][j] == -2)
                    System.out.printf("%s", "   #");
                else
                    System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }
    }

    static void start(int[][] map, int x, int y) {
        map[x][y] = 1;
    }
    static  void finish(int[][] map, int x, int y) {
        map[x][y] = -2;
    }

}

