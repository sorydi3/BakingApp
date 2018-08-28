package com.example.ibrah.baking_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ibrah.baking_app.Utils.QuerryUtils;
import com.example.ibrah.pojos_a.POJOS.Recipies;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ArrayList<Parcelable> mRecipies;
    private int mPOSITION;
    private boolean mTwoPane;
    private Context context;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_ingredients:
                sendData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        FragmentDetails fragmentDetails = new FragmentDetails();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        fragmentManager1.beginTransaction()
                .replace(R.id.container_details, fragmentDetails).commit();

    }


    public void sendData() {
        Intent intent = new Intent(this, IngredientsActivity.class);
        // bundle that hold the data of the currently playing song
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ArrayList", (ArrayList<Recipies>) QuerryUtils.fetchData("", this));
        bundle.putInt("position", mPOSITION);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

