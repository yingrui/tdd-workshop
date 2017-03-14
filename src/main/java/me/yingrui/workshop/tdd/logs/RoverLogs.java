package me.yingrui.workshop.tdd.logs;

import me.yingrui.workshop.tdd.Command;
import me.yingrui.workshop.tdd.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class RoverLogs {

    private List<Log> logs = new ArrayList<>();

    public RoverLogs() {

    }

    public void record(Coordinate from, Coordinate to, Command command) {
        this.logs.add(new Log(from, to, command));
    }

    public int size() {
        return logs.size();
    }
}
