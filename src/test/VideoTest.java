package test;

import icai.dtc.isw.domain.Video;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class VideoTest{

    private Video video;
    URI url = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

    public VideoTest() throws URISyntaxException {
    }

    @org.junit.Before
    public void setUp() throws Exception {
        video = new Video(url, "RR");
    }

    @org.junit.Test
    public void getURL() {
        assertEquals(url, video.getUrl());
    }

    @org.junit.Test
    public void setUrl() throws URISyntaxException {
        URI url2 = new URI("https://www.youtube.com/watch?v=quxTnEEETbo");
        video.setUrl(url2);
        assertEquals(url2, video.getUrl());
    }

    @org.junit.Test
    public void getNombre() {
        assertEquals("RR", video.getNombre());
    }

    @org.junit.Test
    public void setNombre() {
        video.setNombre("MZ");
        assertEquals("MZ", video.getNombre());
    }
}
