package com.example.user.parsejson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.parsejson.adapter.RecyclerViewAdapter;
import com.example.user.parsejson.parsing.ParsingJson;
import com.example.user.parsejson.parsing.model.score.Fixtures;
import com.example.user.parsejson.parsing.model.score.FootballScore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FootballScore mFootballScore;
    private final String URL_FOTBALL_SCORE = "http://api.football-data.org/v1/soccerseasons/424/fixtures";
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFootballScore = new FootballScore();
        ParsingJson parsingJson = new ParsingJson();
        try {
            json = parsingJson.readUrl(URL_FOTBALL_SCORE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mFootballScore = parsingJson.parseFootballScore(json);
        mFootballScore = getOnlyNeeded(mFootballScore, 4);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(mFootballScore);
        // TODO new recyclerView with flag
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }

    private FootballScore getOnlyNeeded(FootballScore footballScore, int matchday) {
        FootballScore result = new FootballScore();
        result.set_links(footballScore.get_links());
        result.setCount(footballScore.getCount());
        List<Fixtures> list = new ArrayList<>();

        for (Fixtures fixtures : footballScore.getFixtures()){
            if (Integer.parseInt(fixtures.getMatchday()) == 4){
                list.add(fixtures);
            }
        }

        Fixtures[] fixtures = new Fixtures[list.size()];
        for (int i = 0; i < list.size(); i++) {
            fixtures[i] = list.get(i);
        }

        result.setFixtures(fixtures);
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
