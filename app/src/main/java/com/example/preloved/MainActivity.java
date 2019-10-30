package com.example.preloved;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView MoveKimora;

    RecyclerView rvCategory;
    private ArrayList<Preloved> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    private String title = "List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(PrelovedData.getListData());
//        showRecyclerList();
        showRecyclerCardView();

        MoveKimora = findViewById(R.id.img_item_photo);

        if (savedInstanceState != null) {
            title = savedInstanceState.getString(STATE_TITLE);
            Log.d("aya", "AYAAN");
        }


//        savedInstanceState.getParcelableArrayList(STATE_LIST);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPrelovedAdapter listPrelovedAdapter = new ListPrelovedAdapter(this);
        listPrelovedAdapter.setListPreloved(list);
        rvCategory.setAdapter(listPrelovedAdapter);
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPrelovedAdapter gridPrelovedAdapter = new GridPrelovedAdapter(this);
        gridPrelovedAdapter.setListPreloved(list);
        rvCategory.setAdapter(gridPrelovedAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPreloved(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPrelovedAdapter cardViewPrelovedAdapter = new CardViewPrelovedAdapter(this);
        cardViewPrelovedAdapter.setListPreloved(list);
        rvCategory.setAdapter(cardViewPrelovedAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPreloved(list.get(position));
            }
        });
    }

    private void showSelectedPreloved(Preloved preloved) {
        Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveIntent.putExtra("kimora", preloved.getName());
        moveIntent.putExtra("lace", preloved.getRemarks());
        moveIntent.putExtra("classic", preloved.getPhoto());
        moveIntent.putExtra("tribal", preloved.getDescription());
        moveIntent.putExtra("size", preloved.getSize());
        moveIntent.putExtra("warna", preloved.getWarna());
        moveIntent.putExtra("harga", preloved.getHarga());
        startActivity(moveIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
//        outState.putParcelableArrayList(STATE_LIST, list);
//        outState.putInt(STATE_MODE, mode);
        outState.putString(STATE_TITLE, "test");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                setActionBarTitle("Mode List");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Mode Grid");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Preloved");
                showRecyclerCardView();
                break;
            case R.id.about_me:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_item_photo:
                Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}