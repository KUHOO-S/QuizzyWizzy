package com.example.quizzywizzy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<Model> models;
    ArrayList<Model> allmodels;
    private OnModelListener oNModelListener;

    public MyAdapter(Context c, ArrayList<Model> models,OnModelListener onModelListener) {
        this.c = c;
        this.models = models;
        this.oNModelListener=onModelListener;
        this.allmodels=new ArrayList<>(models);
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);

        return new MyHolder(view,oNModelListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myholder, int position) {

        myholder.mTitle.setText(models.get(position).getTilte());
        myholder.mDes.setText(models.get(position).getDescription());
        myholder.mImaeview.setImageResource(models.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }



    public interface OnModelListener{
        void OnModelClick(int position);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Model> filteredList=new ArrayList<>();

            if(constraint.toString().isEmpty()) {
                filteredList.addAll(allmodels);
            }
            else {
                for (Model m : allmodels) {
                    if (m.getTilte().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(m);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
                filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            models.clear();
            models.addAll((Collection<? extends Model>) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
