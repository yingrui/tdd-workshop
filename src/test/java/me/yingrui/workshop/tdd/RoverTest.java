package me.yingrui.workshop.tdd;

import me.yingrui.workshop.tdd.camera.Camera;
import me.yingrui.workshop.tdd.logs.RoverLogs;
import org.junit.Test;

import java.io.IOException;

import static me.yingrui.workshop.tdd.Command.*;
import static me.yingrui.workshop.tdd.Dummies.camera;
import static me.yingrui.workshop.tdd.Dummies.roverLogs;
import static me.yingrui.workshop.tdd.stubs.MarsAtlas.Mars;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RoverTest {

    @Test
    public void position_of_rover_should_be_zero_at_beginning() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.North, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_receive_commands() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingEast());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.East, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_north() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingEast());
        rover.send(HeadingNorth());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.North, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(1, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_east() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingEast());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.East, coordinate.getHeading());
        assertEquals(1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_west() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingEast());
        rover.send(Move());
        rover.send(HeadingWest());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.West, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_south() {
        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingNorth());
        rover.send(Move());
        rover.send(HeadingSouth());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.South, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_record_logs_and_take_photo_after_execute_command() throws IOException {
        RoverLogs roverLogs = mock(RoverLogs.class);
        Camera camera = mock(Camera.class);

        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(Move());

        verify(roverLogs, times(1)).record(any(), any(), any());
        verify(camera, times(1)).takePhoto();
    }

    @Test
    public void rover_should_not_take_photo_if_it_just_turn_around() throws IOException {
        Camera camera = mock(Camera.class);

        Rover rover = new Rover(Mars, roverLogs, camera);
        rover.send(HeadingNorth());

        verify(camera, times(0)).takePhoto();
    }
}