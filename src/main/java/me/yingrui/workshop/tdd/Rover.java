package me.yingrui.workshop.tdd;

import me.yingrui.workshop.tdd.camera.Camera;
import me.yingrui.workshop.tdd.logs.RoverLogs;

import java.io.IOException;

import static me.yingrui.workshop.tdd.Coordinate.*;

public class Rover {

    private Atlas atlas;
    private RoverLogs logs;
    private Coordinate coordinate;
    private Camera camera;

    public Rover(Atlas atlas, RoverLogs logs, Camera camera) {
        this.atlas = atlas;
        this.logs = logs;
        this.camera = camera;
        coordinate = new Coordinate(0, 0);
    }

    public Atlas getAtlas() {
        return this.atlas;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void send(Command command) {
        Coordinate next = execute(command);
        record(command, next);
        takePhoto(command);
        this.coordinate = next;
    }

    private void takePhoto(Command command) {
        try {
            if (command.isMovingCommand())
                this.camera.takePhoto();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void record(Command command, Coordinate next) {
        this.logs.record(this.coordinate, next, command);
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
