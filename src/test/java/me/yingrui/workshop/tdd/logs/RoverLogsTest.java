package me.yingrui.workshop.tdd.logs;

import me.yingrui.workshop.tdd.Coordinate;
import org.junit.Test;

import static me.yingrui.workshop.tdd.Command.Move;
import static me.yingrui.workshop.tdd.Coordinate.West;
import static org.junit.Assert.assertEquals;

public class RoverLogsTest {

    @Test
    public void should_be_able_to_record() {
        Coordinate from = new Coordinate(West, 1, 0);
        Coordinate to = new Coordinate(West, 0, 0);

        RoverLogs roverLogs = new RoverLogs();
        assertEquals(0, roverLogs.size());

        roverLogs.record(from, to, Move());
        assertEquals(1, roverLogs.size());
    }

}