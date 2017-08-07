package com.isabella.designdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class OneFragmentAdapter extends RecyclerView.Adapter<OneFragmentAdapter.CViewHolder> {
    private LayoutInflater inflater;
    private List<String> list;
    private Context context;

    public OneFragmentAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public OneFragmentAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ry_item, parent, false);

        CViewHolder viewHolder = new CViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OneFragmentAdapter.CViewHolder holder, int position) {
        holder.title.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public CViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ry_item_tv);

        }
    }
}
