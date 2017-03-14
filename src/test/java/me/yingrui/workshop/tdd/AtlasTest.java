package me.yingrui.workshop.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtlasTest {

    @Test
    public void should_be_able_to_initialize_the_coordinate_system() {
        Atlas atlas = new Atlas(6, 5);
        assertEquals(6, atlas.getTop());
        assertEquals(5, atlas.getRight());
    }
}