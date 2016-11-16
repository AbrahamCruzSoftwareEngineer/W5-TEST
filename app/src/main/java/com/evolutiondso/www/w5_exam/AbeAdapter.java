package com.evolutiondso.www.w5_exam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Albrtx on 15/11/2016.
 */

public class AbeAdapter extends RecyclerView.Adapter<AbeAdapter.ViewHolder> {

    private ArrayList<String> mArrayList;


    @Override
    public AbeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View termView = inflater.inflate(R.layout.item, parent, false);

        return new ViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(AbeAdapter.ViewHolder holder, int position) {
        String string = mArrayList.get(position);

        TextView textViewName = holder.textViewName;
        textViewName.setText(string);
        holder.string = string;

    }


    public AbeAdapter(ArrayList<String> arrayList) {

        this.mArrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    //All the inner clases to set them to STATIC to avoid memory Leaks
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MYTAG";
        public final TextView textViewName;
        public String string;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.r_item_text);

        }

    }
}
