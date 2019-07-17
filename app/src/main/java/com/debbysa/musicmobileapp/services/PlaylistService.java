package com.debbysa.musicmobileapp.services;

import com.debbysa.musicmobileapp.models.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaylistService {

    @GET("/debbysa/dts-server/playlist")
    Call<List<Playlist>> getPlaylist();
}
