package com.example.nikhil.workers.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikhil.workers.R;
import com.example.nikhil.workers.data_model.Items;

import java.util.List;

public class WorkerListAdapter extends RecyclerView.Adapter<WorkerListAdapter.ViewHolder> {

    private Context mContext;
    private List<Items> mWorkersList;
    private  LayoutInflater inflater;

    public WorkerListAdapter(Context context, List<Items> workersList) {
        mWorkersList = workersList;
        mContext = context;
        inflater = LayoutInflater.from(context);


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvWorkerName;


        public ViewHolder(View itemView) {
            super(itemView);
            tvWorkerName = itemView.findViewById(R.id.tv_worker_name);
        }

        @Override
        public void onClick(View view) {

            notifyDataSetChanged();
        }
    }


    @Override
    public WorkerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = inflater.inflate(R.layout.worker_list_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWorkerName.setText(mWorkersList.get(position).getAttributes().getFull_name());
    }

    @Override
    public int getItemCount() {
        return mWorkersList.size();
    }

    public void updateDataList(List<Items> dataList){
        mWorkersList = dataList;
        notifyDataSetChanged();
    }

}
