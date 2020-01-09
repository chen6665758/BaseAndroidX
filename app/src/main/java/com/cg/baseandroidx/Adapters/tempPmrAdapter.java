package com.cg.baseandroidx.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cg.baseandroidx.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class tempPmrAdapter extends RecyclerView.Adapter<tempPmrAdapter.myViewHolder> {

    private Context mContext;
    private List<String> list_data;
    private LayoutInflater inflater;

    public tempPmrAdapter(Context mContext, List<String> list_data) {
        this.mContext = mContext;
        this.list_data = list_data;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.fragment_temp2_item,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txt_item.setText(list_data.get(position));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_item;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_item = (TextView)itemView.findViewById(R.id.txt_item);
        }
    }
}
