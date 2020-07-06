package main.java.com.mazesolver;

class Coordinates {
    private int x;
    private int y;
    private Coordinates parent;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(int x, int y, Coordinates parent) {
        this(x, y);
        this.parent = parent;
    }

    Coordinates(String[] coordinate) {
        this.x = Integer.parseInt(coordinate[1]);
        this.y = Integer.parseInt(coordinate[0]);
    }

    public Coordinates getParent() {
        return parent;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }



}