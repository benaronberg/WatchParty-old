package com.mysampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TabHost;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow mFriendsCoverFlow;
    private FeatureCoverFlow mMyCoverFlow;
    private FeatureCoverFlow mFavoritesCoverFlow;
    private CoverFlowAdapter mFriendsAdapter;
    private CoverFlowAdapter mMyAdapter;
    private CoverFlowAdapter mFavoritesAdapter;
    private ArrayList<ShowEntity> mFriendsShowsData = new ArrayList<>(0);
    private ArrayList<ShowEntity> mMyShowsData = new ArrayList<>(0);
    private ArrayList<ShowEntity> mFavoriteShowsData = new ArrayList<>(0);
    private TextSwitcher mFriendsTitle;
    private TextSwitcher mMyTitle;
    private TextSwitcher mFavoritesTitle;
    private TextView mFriendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.showTabs);
        TabHost tabHubHost = (TabHost)findViewById(R.id.hubTabs);
        host.setup();

        // I Watch Tab
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab_i_watch);
        spec.setIndicator("I Watch");
        host.addTab(spec);

        // Populate I Watch shows
        mMyShowsData.add(new ShowEntity(R.drawable.game_of_thrones, R.string.GOT));
        mMyShowsData.add(new ShowEntity(R.drawable.rick_n_morty, R.string.RickNmort));
        mMyShowsData.add(new ShowEntity(R.drawable.saul, R.string.Saul));
        mMyShowsData.add(new ShowEntity(R.drawable.shameless, R.string.Shameless));

        mMyTitle = (TextSwitcher) findViewById(R.id.title_i_watch);
        mMyTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mMyTitle.setInAnimation(in);
        mMyTitle.setOutAnimation(out);

        mMyAdapter = new CoverFlowAdapter(this);
        mMyAdapter.setData(mMyShowsData);
        mMyCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow_i_watch);
        mMyCoverFlow.setAdapter(mMyAdapter);

        mMyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO CoverFlow item clicked
            }
        });

        mMyCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //TODO CoverFlow stopped to position
            }

            @Override
            public void onScrolling() {
                //TODO CoverFlow began scrolling
            }
        });


        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab_friends_watch);
        spec.setIndicator("Friends Watch");
        host.addTab(spec);

        // Populate Friends Watch shows
        mFriendsShowsData.add(new ShowEntity(R.drawable.game_of_thrones, R.string.GOT));
        mFriendsShowsData.add(new ShowEntity(R.drawable.rick_n_morty, R.string.RickNmort));
        mFriendsShowsData.add(new ShowEntity(R.drawable.saul, R.string.Saul));
        mFriendsShowsData.add(new ShowEntity(R.drawable.shameless, R.string.Shameless));

        mFriendsTitle = (TextSwitcher) findViewById(R.id.title_friends_watch);
        mFriendsTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in_2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out_2 = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mFriendsTitle.setInAnimation(in_2);
        mFriendsTitle.setOutAnimation(out_2);

        mFriendsAdapter = new CoverFlowAdapter(this);
        mFriendsAdapter.setData(mFriendsShowsData);
        mFriendsCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow_friends_watch);
        mFriendsCoverFlow.setAdapter(mFriendsAdapter);

        mFriendsCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO CoverFlow item clicked
            }
        });

        mFriendsCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //TODO CoverFlow stopped to position
            }

            @Override
            public void onScrolling() {
                //TODO CoverFlow began scrolling
            }
        });

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab_favorites);
        spec.setIndicator("Favorites");
        host.addTab(spec);

        // Populate Favorite shows
        mFavoriteShowsData.add(new ShowEntity(R.drawable.game_of_thrones, R.string.GOT));
        mFavoriteShowsData.add(new ShowEntity(R.drawable.rick_n_morty, R.string.RickNmort));
        mFavoriteShowsData.add(new ShowEntity(R.drawable.saul, R.string.Saul));
        mFavoriteShowsData.add(new ShowEntity(R.drawable.shameless, R.string.Shameless));

        mFavoritesTitle = (TextSwitcher) findViewById(R.id.title_favorites);
        mFavoritesTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in_3 = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out_3 = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mFavoritesTitle.setInAnimation(in_3);
        mFavoritesTitle.setOutAnimation(out_3);

        mFavoritesAdapter = new CoverFlowAdapter(this);
        mFavoritesAdapter.setData(mFavoriteShowsData);
        mFavoritesCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow_favorites);
        mFavoritesCoverFlow.setAdapter(mFavoritesAdapter);

        mFavoritesCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO CoverFlow item clicked
            }
        });

        mFavoritesCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //TODO CoverFlow stopped to position
            }

            @Override
            public void onScrolling() {
                //TODO CoverFlow began scrolling
            }
        });
/**
        //Friends Tab
        Intent tabHubIntent = new Intent(this, HubTabs.class);
        spec = tabHubHost.newTabSpec("Friends Tab");
        spec.setIndicator("Friends");
        spec.setContent(tabHubIntent);
        host.addTab(spec);

        // Populate friends list
        mFriendsList = (TextView) findViewById(R.id.friends_list);
        String[] friendsList = Friends.getFriendsList();
        for (String friend : friendsList) {
            mFriendsList.append(friend + "\n\n");
        }
*/

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
