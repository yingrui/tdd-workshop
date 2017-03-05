package me.yingrui.workshop.tdd;

public class Rover {

    private Atlas atlas;
    private Coordinate coordinate;

    public Rover(int top, int right) {
        atlas = new Atlas(top, right);
        coordinate = new Coordinate(0, 0);
    }

    public Atlas getAtlas() {
        return this.atlas;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void send(Command command) {

    }
}
