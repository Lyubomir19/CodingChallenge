package com.example.codingchallenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.codingchallenge.R;
import com.example.codingchallenge.model.Repo;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    Context mContext;
    List<Repo> repoList;

    public RepoAdapter(Context context, List<Repo> repoList) {
        this.mContext = context;
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.ViewHolder holder, int position) {
        Repo repo = repoList.get(position);

        Glide.with(mContext)
                .load(repo.getOwner().getAvatar_url())
                .into(holder.imgView);

        holder.tvName.setText(repo.getName());
        holder.tvDescription.setText(repo.getDescription());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView tvName;
        TextView tvDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView =  itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);;
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
