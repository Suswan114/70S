package com.example.a7os.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a7os.R;
import com.example.a7os.adapters.LeaderboardAdapter;
import com.example.a7os.modelClasses.LeaderboardModelClass;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<LeaderboardModelClass> leaderboardList;
    LeaderboardAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_leaderboard,container,false);
        initData();
        recyclerView= view.findViewById(R.id.leaderboard_recycler);
        layoutManager=new LinearLayoutManager(getActivity().getParent());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new LeaderboardAdapter(getContext(),leaderboardList);
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        return view;
    }

    public void initData() {

        leaderboardList=new ArrayList<>();



        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("1","Swapan","110"));
        leaderboardList.add(new LeaderboardModelClass("2","Swapan","110"));


    }
}
