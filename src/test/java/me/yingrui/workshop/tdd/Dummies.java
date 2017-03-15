package me.yingrui.workshop.tdd;

import me.yingrui.workshop.tdd.camera.Camera;
import me.yingrui.workshop.tdd.logs.RoverLogs;
import static org.mockito.Mockito.*;

public class Dummies {

    public static final RoverLogs roverLogs = mock(RoverLogs.class);
    public static final Camera camera = mock(Camera.class);

}
