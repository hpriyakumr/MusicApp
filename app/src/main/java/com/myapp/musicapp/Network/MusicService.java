package com.myapp.musicapp.Network;

import com.myapp.musicapp.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusicService {

    String BASE_URL = "http://rallycoding.herokuapp.com/api/";
    @GET("music_albums")
    Call<List<Music>> getAllMusicList();
}
