package com.example.user.parsejson.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.parsejson.R;
import com.example.user.parsejson.retrofit.models.football_season.FootballSeasonModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private FootballSeasonModel mFootballSeasonModel;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextViewFirstTeam;
        TextView mTextViewSecondTeam;
        TextView mTextViewGoalsFirstTeam;
        TextView mTextViewGoalsSecondTeam;
        ImageView mIconFirstTeam;
        ImageView mIconSecondTeam;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mTextViewFirstTeam = (TextView) itemView.findViewById(R.id.mFirstTeam);
            mTextViewSecondTeam = (TextView) itemView.findViewById(R.id.mSecondTeam);
            mTextViewGoalsFirstTeam = (TextView) itemView.findViewById(R.id.mGoalsFirstTeam);
            mTextViewGoalsSecondTeam = (TextView) itemView.findViewById(R.id.mGoalsSecondTeam);
            mIconFirstTeam = (ImageView) itemView.findViewById(R.id.icon_first_team);
            mIconSecondTeam = (ImageView) itemView.findViewById(R.id.icon_second_team);
        }
    }

    public RecyclerViewAdapter(FootballSeasonModel mFootballSeasonModel) {
        this.mFootballSeasonModel = mFootballSeasonModel;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextViewFirstTeam
                .setText(mFootballSeasonModel.getFixtures().get(position).getHomeTeamName());
        holder.mTextViewSecondTeam
                .setText(mFootballSeasonModel.getFixtures().get(position).getAwayTeamName());

        holder.mTextViewGoalsFirstTeam
                .setText(goalsFirstTeam(position));
        holder.mTextViewGoalsSecondTeam
                .setText(goalsSecondTeam(position));
        holder.mCardView.setTag(position);
    }

    private String goalsFirstTeam(int position) {
        int firstTime = mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getGoalsHomeTeam();

        int secondTime = mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getHalfTime()
                .getGoalsHomeTeam();

        int extraTime = 0;
        if (mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getExtraTime() != null) {
            extraTime = mFootballSeasonModel.getFixtures().get(position)
                    .getResult()
                    .getExtraTime()
                    .getGoalsHomeTeam();
        }

        int penaltyTime = 0;
        if (mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getPenaltyShootout() != null) {
            penaltyTime = mFootballSeasonModel.getFixtures().get(position)
                    .getResult()
                    .getPenaltyShootout()
                    .getGoalsHomeTeam();
        }
        return String.valueOf(firstTime + secondTime + extraTime + penaltyTime);
    }

    private String goalsSecondTeam(int position) {
        int firstTime = mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getGoalsAwayTeam();

        int secondTime = mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getHalfTime()
                .getGoalsAwayTeam();

        int extraTime = 0;
        if (mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getExtraTime() != null) {
            extraTime = mFootballSeasonModel.getFixtures().get(position)
                    .getResult()
                    .getExtraTime()
                    .getGoalsAwayTeam();
        }

        int penaltyTime = 0;
        if (mFootballSeasonModel.getFixtures().get(position)
                .getResult()
                .getPenaltyShootout() != null) {
            penaltyTime = mFootballSeasonModel.getFixtures().get(position)
                    .getResult()
                    .getPenaltyShootout()
                    .getGoalsAwayTeam();
        }
        return String.valueOf(firstTime + secondTime + extraTime + penaltyTime);
    }

    @Override
    public int getItemCount() {
        if (mFootballSeasonModel.getFixtures() == null){
            return 0;
        }
        return mFootballSeasonModel.getFixtures().size();
    }
}
