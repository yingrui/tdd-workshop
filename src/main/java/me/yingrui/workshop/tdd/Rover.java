package me.yingrui.workshop.tdd;

public class Rover {

    private Atlas atlas;

    public Rover(int top, int right) {
        atlas = new Atlas(top, right);
    }

    public Atlas getAtlas() {
        return this.atlas;
    }
}
