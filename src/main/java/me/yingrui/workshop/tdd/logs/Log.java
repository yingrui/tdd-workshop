package me.yingrui.workshop.tdd.logs;

import me.yingrui.workshop.tdd.Command;
import me.yingrui.workshop.tdd.Coordinate;

public class Log {

    private Coordinate from;
    private Coordinate to;
    private Command command;

    public Log(Coordinate from, Coordinate to, Command command) {
        this.from = from;
        this.to = to;
        this.command = command;
    }

    public Coordinate getFrom() {
        return from;
    }

    public Coordinate getTo() {
        return to;
    }

    public Command getCommand() {
        return command;
    }
}
