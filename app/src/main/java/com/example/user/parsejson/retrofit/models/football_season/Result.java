
package com.example.user.parsejson.retrofit.models.football_season;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("goalsHomeTeam")
    @Expose
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Integer goalsAwayTeam;
    @SerializedName("halfTime")
    @Expose
    private HalfTime halfTime;
    @SerializedName("extraTime")
    @Expose
    private ExtraTime extraTime;
    @SerializedName("penaltyShootout")
    @Expose
    private PenaltyShootout penaltyShootout;

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public HalfTime getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(HalfTime halfTime) {
        this.halfTime = halfTime;
    }

    public ExtraTime getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(ExtraTime extraTime) {
        this.extraTime = extraTime;
    }

    public PenaltyShootout getPenaltyShootout() {
        return penaltyShootout;
    }

    public void setPenaltyShootout(PenaltyShootout penaltyShootout) {
        this.penaltyShootout = penaltyShootout;
    }

}
