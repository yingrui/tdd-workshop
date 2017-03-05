package me.yingrui.workshop.tdd;

public class Coordinate {

    public static final String North = "N";
    public static final String East = "E";
    public static final String West = "W";

    private String heading;
    private int x;
    private int y;

    public Coordinate(String heading, int x, int y) {
        this.heading = heading;
        this.x = x;
        this.y = y;
    }

    public Coordinate(int x, int y) {
        this(North, x, y);
    }

    public String getHeading() {
        return heading;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
