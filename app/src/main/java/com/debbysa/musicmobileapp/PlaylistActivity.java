package com.debbysa.musicmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.debbysa.musicmobileapp.adapters.PlaylistAdapter;
import com.debbysa.musicmobileapp.generator.ServiceGenerator;
import com.debbysa.musicmobileapp.models.Playlist;
import com.debbysa.musicmobileapp.services.PlaylistService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistActivity extends AppCompatActivity {

    //instansiasi Recyclerview
    public RecyclerView rvPlaylist;

    public PlaylistAdapter playlistAdapter;
    public RecyclerView.LayoutManager layoutManager;

    private PlaylistService playlistService;
    private Playlist playlist;
    private PlaylistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        rvPlaylist = findViewById(R.id.rvPlaylist);

        playlistService = ServiceGenerator.createService(PlaylistService.class);

        layoutManager = new LinearLayoutManager(getApplicationContext());

        Call<List<Playlist>> playlistCall = playlistService.getPlaylist();

        playlistCall.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                List<Playlist> playlists = response.body();
                rvPlaylist.setAdapter(new PlaylistAdapter(playlists, R.layout.item_playlist, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Toast.makeText(PlaylistActivity.this, "Gagal download data", Toast.LENGTH_SHORT).show();
            }
        });

//        rvPlaylist.setAdapter(playlistAdapter);
        rvPlaylist.setLayoutManager(layoutManager);
    }
}
