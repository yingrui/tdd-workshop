package me.yingrui.workshop.tdd.camera;

import com.github.dreamhead.moco.RestServer;
import com.github.dreamhead.moco.Runner;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.MocoRest.restServer;
import static com.github.dreamhead.moco.Runner.runner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CameraIntegrationTest {

    private Runner runner;
    private int mockServerPort = 55556;

    @Before
    public void setup() throws Exception {
        RestServer server = restServer(mockServerPort);

        server.post(and(by(uri("/")))).response("Success");
        runner = runner(server);
        runner.start();
    }

    @After
    public void tearDown() {
        runner.stop();
    }

    @Test
    public void should_send_back_photo_to_remote_server() {
        HttpClient client = HttpClientBuilder.create().build();
        String controlCenterUri = "http://localhost:" + mockServerPort + "/";
        Camera camera = new Camera(controlCenterUri, client);
        try {
            Boolean status = camera.takePhoto();
            assertTrue(status);
        } catch (Exception ex) {
            fail();
        }
    }
}
