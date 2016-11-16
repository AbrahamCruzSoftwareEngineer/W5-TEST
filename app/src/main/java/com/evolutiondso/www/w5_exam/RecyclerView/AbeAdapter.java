package com.evolutiondso.www.w5_exam.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evolutiondso.www.w5_exam.R;
import com.evolutiondso.www.w5_exam.entities.SearchResult;

import java.util.List;

/**
 * Created by Albrtx on 15/11/2016.
 */

public class AbeAdapter extends RecyclerView.Adapter<SimpleAdapter> {

        List<SearchResult> list;
        Context context;

        public AbeAdapter(List<SearchResult> list, Context context) {
            this.list = list;
            this.context = context;
        }

        public AbeAdapter(List<SearchResult> list) {
            this.list = list;
        }



    @Override
        public SimpleAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
            //Inflate the layout, initialize the View Holder
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            SimpleAdapter holder = new SimpleAdapter(v);
            return holder;

        }

        @Override
        public void onBindViewHolder(SimpleAdapter holder, int position) {

            //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
            holder.name.setText(list.get(position).getListing().getName());

        }

        @Override
        public int getItemCount() {
            //returns the number of elements the RecyclerView will display
            return list.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

    }