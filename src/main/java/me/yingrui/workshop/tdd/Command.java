package me.yingrui.workshop.tdd;

public class Command {

    private String order;

    public Command(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public static Command HeadingNorth() {
        return new Command("N");
    }

    public static Command HeadingSouth() {
        return new Command("S");
    }

    public static Command HeadingEast() {
        return new Command("E");
    }

    public static Command HeadingWest() {
        return new Command("W");
    }

    public static Command Move() {
        return new Command("M");
    }
}
