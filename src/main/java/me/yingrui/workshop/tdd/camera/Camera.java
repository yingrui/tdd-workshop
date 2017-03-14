package me.yingrui.workshop.tdd.camera;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

public class Camera {

    private String earthControlCenter;
    private HttpClient httpClient;

    public Camera(String earthControlCenter, HttpClient httpClient) {
        this.earthControlCenter = earthControlCenter;
        this.httpClient = httpClient;
    }

    public void takePhoto() throws IOException {
        String photo = "This is the photo around rover";
        HttpPost post = new HttpPost(earthControlCenter);
        post.setEntity(new StringEntity(photo));
        httpClient.execute(post);
    }

}
