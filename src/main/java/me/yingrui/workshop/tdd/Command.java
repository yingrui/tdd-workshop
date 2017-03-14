package me.yingrui.workshop.tdd;

import static me.yingrui.workshop.tdd.Coordinate.*;

public class Command {

    private String order;
    private final static String Move = "M";

    private Command(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public boolean isMovingCommand() {
        return getOrder().equals(Move);
    }

    public static Command HeadingNorth() {
        return new Command(North);
    }

    public static Command HeadingSouth() {
        return new Command(South);
    }

    public static Command HeadingEast() {
        return new Command(East);
    }

    public static Command HeadingWest() {
        return new Command(West);
    }

    public static Command Move() {
        return new Command(Move);
    }
}
