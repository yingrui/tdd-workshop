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
        this.coordinate = execute(command);
    }

    private Coordinate execute(Command command) {
        if (command.getOrder().equals(Coordinate.East)) {
            return new Coordinate(Coordinate.East, this.coordinate.getX(), this.coordinate.getY());
        }
        if (command.getOrder().equals(Coordinate.West)) {
            return new Coordinate(Coordinate.West, this.coordinate.getX(), this.coordinate.getY());
        }
        if (command.getOrder().equals("M")) {
            return move();
        }
        return null;
    }

    private Coordinate move() {
        if (this.coordinate.getHeading().equals(Coordinate.North)) {
            return new Coordinate(this.coordinate.getHeading(), this.coordinate.getX(), this.coordinate.getY() + 1);
        }

        if (this.coordinate.getHeading().equals(Coordinate.East)) {
            return new Coordinate(this.coordinate.getHeading(), this.coordinate.getX() + 1, this.coordinate.getY());
        }

        if (this.coordinate.getHeading().equals(Coordinate.West)) {
            return new Coordinate(this.coordinate.getHeading(), this.coordinate.getX() - 1, this.coordinate.getY());
        }
        return null;
    }
}
