package com.example.exam.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlbumGateway {
    @Autowired
    private RestTemplate restTemplate;

    public AlbumEntity getAlbumById(int id){
        String url = "https://jsonplaceholder.typicode.com/photos/" + id;
        AlbumEntity album = restTemplate.getForObject(url, AlbumEntity.class);
        return album;
    }

//    public AlbumEntity[] getAlbumsByRange(int start, int end){
//        return []
//    }
}
