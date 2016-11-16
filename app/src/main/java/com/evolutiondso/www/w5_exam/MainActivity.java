package com.evolutiondso.www.w5_exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.evolutiondso.www.w5_exam.Dagger.component.DaggerNetComponent;
import com.evolutiondso.www.w5_exam.Dagger.module.NetModule;
import com.evolutiondso.www.w5_exam.RecyclerView.AbeAdapter;
import com.evolutiondso.www.w5_exam.entities.ResultAPI;
import com.evolutiondso.www.w5_exam.entities.SearchResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private AbeAdapter adapter;
    private List<SearchResult> list;
    @BindView(R.id.a_main_recycler)
    RecyclerView recyclerViewView;

    @Inject
    Retrofit retrofit;
    @Inject
    Show shows;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DAGGER

        DaggerNetComponent.builder()
                .netModule(new NetModule(this))
                .build()
                .inject(this);

        //BUTTERKNIFE
        ButterKnife.bind(this);



        //CREATE THE RESULT
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewView.setLayoutManager(layoutManager);

        //SET LIST ABEADAPTER
        list = new ArrayList<>();
        adapter = new AbeAdapter(list, getApplicationContext());
        recyclerViewView.setAdapter(adapter);

    }

    public void searchingOn(){
        Call<ResultAPI> call = shows.retrieveListings("USD");
        call.enqueue(new Callback<ResultAPI>() {
            @Override
            public void onResponse(Call<ResultAPI> call, Response<ResultAPI> response) {
                ResultAPI resultAPI = response.body();
                list = resultAPI.getSearchResults();
                adapter = new AbeAdapter(list);
                adapter.notifyDataSetChanged();
                recyclerViewView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResultAPI> call, Throwable t) {

            }
        });
    }

    public void ButtonMagic(View view) {
        searchingOn();
    }


}
