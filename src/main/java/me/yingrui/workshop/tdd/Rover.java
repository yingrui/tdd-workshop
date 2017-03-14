package me.yingrui.workshop.tdd;

import static me.yingrui.workshop.tdd.Coordinate.*;

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
        this.coordinate = execute(command);
    }

    private Coordinate execute(Command command) {
        if (command.isMovingCommand()) {
            return move();
        }
        return new Coordinate(command.getOrder(), this.coordinate.getX(), this.coordinate.getY());
    }

    private Coordinate move() {
        String heading = this.coordinate.getHeading();

        int x = this.coordinate.getX();
        int y = this.coordinate.getY();
        if (heading.equals(North)) {
            y += 1;
        }

        if (heading.equals(East)) {
            x += 1;
        }

        if (heading.equals(West)) {
            x -= 1;
        }

        if (heading.equals(South)) {
            y -= 1;
        }
        return new Coordinate(heading, x, y);
    }
}
