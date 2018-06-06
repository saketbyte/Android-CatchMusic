package com.nsh.catchmusic;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsh.catchmusic.adapter.SongAdapter;
import com.nsh.catchmusic.model.Song;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView rec_singer, rec_album;
    TextView name, album, singer;
    ImageView imageView;
    CircleImageView button;
    SongAdapter singerAdapter, albumAdapter;
    List<Song> singerList, albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUI();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        new LoadAsyncTask().execute();
    }

    public void preparedata() {
        Song song = new Song("Name", "url", "Singer");
        singerList.add(song);
        singerList.add(song);
        singerList.add(song);
        singerList.add(song);
        albumList.add(song);
        albumList.add(song);
        albumList.add(song);
        albumList.add(song);
        albumAdapter.notifyDataSetChanged();
        singerAdapter.notifyDataSetChanged();
    }

    public void initUI() {
        rec_album = findViewById(R.id.rec_m_album);
        rec_singer = findViewById(R.id.rec_m_singer);
        name = findViewById(R.id.name);
        album = findViewById(R.id.album);
        singer = findViewById(R.id.singer);
        imageView = findViewById(R.id.pic);
        button = findViewById(R.id.play);
    }

    public class LoadAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            singerList = new ArrayList<>();
            albumList = new ArrayList<>();
            singerAdapter = new SongAdapter(singerList);
            albumAdapter = new SongAdapter(albumList);

            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
            rec_singer.setLayoutManager(llm);
            rec_singer.setAdapter(singerAdapter);
            rec_singer.setItemAnimator(new DefaultItemAnimator());

            LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
            llm1.setOrientation(LinearLayoutManager.HORIZONTAL);
            rec_album.setLayoutManager(llm1);
            rec_album.setAdapter(albumAdapter);
            rec_album.setItemAnimator(new DefaultItemAnimator());

            preparedata();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
