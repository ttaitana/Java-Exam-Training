package com.example.exam.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
public class AlbumGateway {
    @Autowired
    private RestTemplate restTemplate;

    public AlbumEntity getAlbumById(int id){
        String url = "https://jsonplaceholder.typicode.com/photos/" + id;
        AlbumEntity album = restTemplate.getForObject(url, AlbumEntity.class);
        return album;
    }

    public ArrayList<AlbumEntity> getAlbumsByRange(int start, int end){
        ArrayList<AlbumEntity> result = new ArrayList<>();
        for (int i = start; i < end; i++){
            result.add(getAlbumById(i));
        }
        return result;
    }
}
