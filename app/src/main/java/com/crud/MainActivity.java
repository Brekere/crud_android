package com.crud;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<StoreEntity> storeEntityArrayList;
    private RecyclerViewStoreAdapter adapter;
    private int recyclerViewItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buildRecyclerView();

        getSupportActionBar().setTitle("Tiendas");
    }

    private void buildRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewStore);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        storeEntityArrayList = new ArrayList<>();

        adapter = new RecyclerViewStoreAdapter(this, storeEntityArrayList);
        recyclerView.setAdapter(adapter);

// Muestra el menu contextual
        adapter.setOnLongItemCustomListener(new RecyclerViewStoreAdapter.OnLongItemCustomListener() {
            @Override
            public void ItemLongClicked(View v, int position) {
                recyclerViewItemSelected = position;
                v.showContextMenu();
            }
        });

        registerForContextMenu(recyclerView);
    }

    // Menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options_bar,
                menu);
        return true;
    }
}
