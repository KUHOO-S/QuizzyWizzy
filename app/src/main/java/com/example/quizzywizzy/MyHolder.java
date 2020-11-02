package com.example.quizzywizzy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

    TextView mTitle,mDes;
    ImageView mImaeview;
    MyAdapter.OnModelListener onModelListener;
    public MyHolder(@NonNull View itemView, MyAdapter.OnModelListener onModelListener) {
        super(itemView);
        mTitle=itemView.findViewById(R.id.titleTv);
        mDes=itemView.findViewById(R.id.descriptionTv);
        mImaeview=itemView.findViewById(R.id.imageTv);
        this.onModelListener=onModelListener;
        itemView.setOnClickListener(this );
    }

    @Override
    public void onClick(View v) {
        onModelListener.OnModelClick(getAdapterPosition());

    }


}
