package com.debbysa.musicmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.debbysa.musicmobileapp.R;
import com.debbysa.musicmobileapp.models.Playlist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.MyViewHolder> {

    List<Playlist> playlists;

    public PlaylistAdapter(List<Playlist> playlists, int item_playlist, Context applicationContext) {
        this.playlists = playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlaylistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_playlist,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.MyViewHolder holder, int position) {
        Playlist item = playlists.get(position);
        Picasso.get().load(item.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.musicImage);
        holder.musicTitle.setText(item.getTitle());
        holder.artist.setText(item.getArtist());
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView musicTitle, artist;
        public ImageView musicImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            musicImage = itemView.findViewById(R.id.musicImage);
            artist = itemView.findViewById(R.id.artist);
            musicTitle = itemView.findViewById(R.id.musictitle);
        }
    }
}
