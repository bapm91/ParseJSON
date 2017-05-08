package com.example.user.parsejson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.parsejson.adapter.RecyclerViewAdapter;
import com.example.user.parsejson.retrofit.models.football_season.Fixture;
import com.example.user.parsejson.retrofit.models.football_season.FootballSeasonModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private FootballSeasonModel posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        posts = new FootballSeasonModel();
        setRecyclerView();
        getAndParsJSON();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void getAndParsJSON() {
        App.getApi().getData().enqueue(new Callback<FootballSeasonModel>() {
            @Override
            public void onResponse(Call<FootballSeasonModel> call, Response<FootballSeasonModel> response) {
                posts = response.body();
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FootballSeasonModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(posts);
//        if (recyclerView != null) {
//            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
//        }
    }

    private FootballSeasonModel getOnlyNeeded(FootballSeasonModel footballScore, int matchday) {
        List<Fixture> list = new ArrayList<>();

        for (Fixture fixtures : footballScore.getFixtures()) {
            if (fixtures.getMatchday() == matchday) {
                list.add(fixtures);
            }
        }

        FootballSeasonModel result = new FootballSeasonModel();
        result.setLinks(footballScore.getLinks());
        result.setCount(footballScore.getCount());
        result.setFixtures(list);
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
