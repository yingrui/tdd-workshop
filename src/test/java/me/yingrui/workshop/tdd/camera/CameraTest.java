package me.yingrui.workshop.tdd.camera;

import org.apache.http.client.HttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CameraTest {

    @Test
    public void should_send_back_photo() throws IOException {
        HttpClient client = mock(HttpClient.class);
        String dummyUri = "earth-control-center";
        Camera camera = new Camera(dummyUri, client);
        camera.takePhoto();

        verify(client, times(1)).execute(any());
    }

}