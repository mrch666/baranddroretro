package ru.specinstrument.instrumentstore.modelgoods.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.specinstrument.instrumentstore.modelgoods.models.Modelgoods;
import in.androidmate.anujgupta.movify.R;

/**
 * Created by anujgupta on 26/12/17.
 */

public class ModelgoodsAdapter extends RecyclerView.Adapter<ModelgoodsAdapter.ModelgoodsHolder> {

    List<Modelgoods> modelgoodsList;
    Context context;

    public ModelgoodsAdapter(List<Modelgoods> modelgoodsList, Context context) {
        this.modelgoodsList = modelgoodsList;
        this.context = context;
    }

    @Override
    public ModelgoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_modegoods,parent,false);
        ModelgoodsHolder mh = new ModelgoodsHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ModelgoodsHolder holder, int position) {

        holder.tvTitle.setText(modelgoodsList.get(position).getName());
        holder.tvOverview.setText(modelgoodsList.get(position).getPrintprior());
        holder.tvReleaseDate.setText(modelgoodsList.get(position).getChangedate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+ modelgoodsList.get(position).getUserid()).into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return modelgoodsList.size();
    }

    public class ModelgoodsHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;

        public ModelgoodsHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
            ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }
}
