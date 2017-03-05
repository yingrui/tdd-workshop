package me.yingrui.workshop.tdd;

public class Command {

    private String order;

    public Command(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public static Command HeadingEast() {
        return new Command("E");
    }
}
