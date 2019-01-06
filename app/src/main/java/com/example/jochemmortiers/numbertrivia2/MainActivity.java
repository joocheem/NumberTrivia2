package com.example.jochemmortiers.numbertrivia2;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private RecyclerView mRecylerView;
    private NummerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Nummer> nummerList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        mRecylerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(mLayoutManager);
        mRecylerView.setHasFixedSize(true);

        mAdapter = new NummerAdapter(this, nummerList);
        mRecylerView.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIInterface service = APIInterface.retrofit.create(APIInterface.class);

                Call<Nummer> call = service.getRandomNumber();

                call.enqueue(new Callback<Nummer>() {
                    @Override
                    public void onResponse(Call <Nummer> call, Response<Nummer> response) {
                        Nummer randomNumber = response.body();
                        nummerList.add(randomNumber);

                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Nummer> call, Throwable e) {
                        Log.d("error", e.toString());
                    }

                });
            }
        });

    }

}
