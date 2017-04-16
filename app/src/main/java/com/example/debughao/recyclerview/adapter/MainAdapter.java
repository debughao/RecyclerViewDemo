package com.example.debughao.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.debughao.recyclerview.R;

/**
 * Created by debughao on 2017/4/16.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerHolder>{
  public  static final   String[] contents = new String[]{"纵向列表","横向列表","纵向网格","横向网格","纵向瀑布流","横向瀑布流"};
    private Context context;
    private OnItemClickListener onItemClickListener;
    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MainAdapter.RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_menu, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.RecyclerHolder holder, int position) {
        holder.content.setText(contents[position]);
    }

    @Override
    public int getItemCount() {
        return contents.length;
    }
    class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView content;
        private CardView cardview;
        public RecyclerHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.item_content);
            content = (TextView) itemView.findViewById(R.id.item_content);
            cardview = (CardView) itemView.findViewById(R.id.item_cardview);
            cardview.setOnClickListener(this);
        }

        public void setData(int position) {
            content.setText(contents[position]);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null)
                onItemClickListener.onItemClick(getLayoutPosition());
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
