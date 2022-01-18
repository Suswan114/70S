package com.example.a7os.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a7os.R;
import com.example.a7os.modelClasses.LeaderboardModelClass;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {


    private List<LeaderboardModelClass> leaderboardList;



    public LeaderboardAdapter(Context context, List<LeaderboardModelClass>leaderboardList){
        this.leaderboardList=leaderboardList;
    }


    @NonNull
    @Override
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder holder, int position) {
        String rank_res=leaderboardList.get(position).getRank();
        String name_res=leaderboardList.get(position).getName();
        String score_res=leaderboardList.get(position).getScore();

        holder.setData(rank_res,name_res,score_res);


    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView rank,name,score;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rank=itemView.findViewById(R.id.position);
            name=itemView.findViewById(R.id.name);
            score=itemView.findViewById(R.id.score_leaderboard);

        }

        public void setData(String rank_res, String name_res, String score_res) {
             rank.setText(rank_res);
             name.setText(name_res);
             score.setText(score_res);
        }
    }
}
