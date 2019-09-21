package com.myapp.musicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private ArrayList<Music> list;

    public MusicAdapter(ArrayList<Music> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_single_view,parent,false);
        return new MusicAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music ml = list.get(position);
        Picasso.get().load(ml.getThumbnail_image()).into(holder.imageView_thumbnail_image);
        holder.tv_title.setText(ml.getTitle());
        holder.tv_artist.setText(ml.getArtist());
        Picasso.get().load(ml.getImage()).into(holder.iv_image);
        holder.bt_buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        } else{
            return 0;
        }
    }

    public void setData(ArrayList<Music> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView imageView_thumbnail_image;
        private TextView tv_artist;
        private ImageView iv_image;
        private Button bt_buy_now;

        public ViewHolder(View view) {
            super(view);
            this.imageView_thumbnail_image = (ImageView) view.findViewById(R.id.iv_thumbnail_image);
            this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            this.tv_artist = (TextView) view.findViewById(R.id.tv_artist);
            this.iv_image = (ImageView) view.findViewById(R.id.iv_image);
            this.bt_buy_now = (Button) view.findViewById(R.id.bt_url);
        }
    }
}
