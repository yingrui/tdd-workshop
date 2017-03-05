package me.yingrui.workshop.tdd;

import org.junit.Test;

import static me.yingrui.workshop.tdd.Command.*;
import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void should_be_able_to_initialize_the_coordinate_system() {
        Rover rover = new Rover(5, 5);
        Atlas atlas = rover.getAtlas();
        assertEquals(5, atlas.getTop());
        assertEquals(5, atlas.getRight());
    }

    @Test
    public void position_of_rover_should_be_zero_at_beginning() {
        Rover rover = new Rover(5, 5);
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.North, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_receive_commands() {
        Rover rover = new Rover(5, 5);
        rover.send(HeadingEast());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.East, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void rover_should_be_able_to_move() {
        Rover rover = new Rover(5, 5);
        rover.send(Move());
        Coordinate coordinate = rover.getCoordinate();
        assertEquals(Coordinate.North, coordinate.getHeading());
        assertEquals(0, coordinate.getX());
        assertEquals(1, coordinate.getY());
    }

}