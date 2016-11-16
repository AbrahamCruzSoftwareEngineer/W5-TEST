package com.evolutiondso.www.w5_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private ArrayList<String> mArrayList;
    //    private SimpleAdapter mSimpleAdapter;
    private AbeAdapter mSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mArrayList = new ArrayList<>();
        mSimpleAdapter = new AbeAdapter(mArrayList);


        mRecyclerView = (RecyclerView) findViewById(R.id.a_main_recycler);
        mRecyclerView.setAdapter(mSimpleAdapter);
        //Layout Manager
        //Con el horizontal se hace en una sola linea y con el Vertical se hace una lista hacia abajo
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        //Grid Layour Manager
        //
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false));

        //Stagger Grid Manager
        //
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }

}
