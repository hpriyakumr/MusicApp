package com.myapp.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.myapp.musicapp.Network.MusicService;
import com.myapp.musicapp.Network.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rv_music_view;
    private MusicAdapter adapter;
    ArrayList<Music> musicArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rv_music_view = findViewById(R.id.rv_album_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_music_view.setLayoutManager(mLayoutManager);

        getMusicList();

    }

    protected void getMusicList(){

        /*Create handle for the RetrofitInstance interface*/
        MusicService service = RetrofitClient.getRetrofitInstance().create(MusicService.class);
        Call<List<Music>> call = service.getAllMusicList();
        call.enqueue(new Callback<List<Music>>() {
            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {

                updateUI(response.body());
                Log.d("messages", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void updateUI(List<Music> musicLists){

        musicArrayList = new ArrayList<Music>(musicLists);
        adapter = new MusicAdapter(musicArrayList);
        rv_music_view.setAdapter(adapter);
        adapter.setData(musicArrayList);

    }
}
