package me.yingrui.workshop.tdd;

import org.junit.Test;

import static me.yingrui.workshop.tdd.Command.*;
import static me.yingrui.workshop.tdd.stubs.MarsAtlas.Mars;
import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Test
    public void position_of_rover_should_be_zero_at_beginning() {
        Rover rover = new Rover(Mars);
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.North, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_receive_commands() {
        Rover rover = new Rover(Mars);
        rover.send(HeadingEast());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.East, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_north() {
        Rover rover = new Rover(Mars);
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
        Rover rover = new Rover(Mars);
        rover.send(HeadingEast());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.East, coordinate.getHeading());
        assertEquals(1, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move_towards_west() {
        Rover rover = new Rover(Mars);
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
        Rover rover = new Rover(Mars);
        rover.send(HeadingNorth());
        rover.send(Move());
        rover.send(HeadingSouth());
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.South, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

}