package com.evolutiondso.www.w5_exam.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.evolutiondso.www.w5_exam.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Albrtx on 15/11/2016.
 */

public class SimpleAdapter extends RecyclerView.ViewHolder {
    @BindView(R.id.r_item_text)
    TextView name;

    SimpleAdapter(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}