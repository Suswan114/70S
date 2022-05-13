package com.example.a7os.modelClasses;

public class LeaderboardModelClass {

    private String rank,name,score;

    public LeaderboardModelClass(String rank, String name, String score){
        this.rank=rank;
        this.name=name;
        this.score=score;

    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
