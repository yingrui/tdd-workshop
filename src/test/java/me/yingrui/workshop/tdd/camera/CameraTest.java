package me.yingrui.workshop.tdd.camera;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CameraTest {

    @Test
    public void should_send_back_photo() throws IOException {
        HttpClient client = mock(HttpClient.class);
        HttpResponse response = mock(HttpResponse.class);
        StatusLine statusLine = mock(StatusLine.class);
        
        when(client.execute(any())).thenReturn(response);
        when(response.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);

        String dummyUri = "earth-control-center";
        Camera camera = new Camera(dummyUri, client);
        Boolean status = camera.takePhoto();
        assertTrue(status);

        verify(client, times(1)).execute(any());
    }

}