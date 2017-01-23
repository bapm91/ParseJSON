package com.example.user.parsejson.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.parsejson.R;
import com.example.user.parsejson.parsing.model.score.FootballScore;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private FootballScore mFootballScore;

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

    public RecyclerViewAdapter(FootballScore mFootballScore) {
        this.mFootballScore = mFootballScore;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextViewFirstTeam
                .setText(mFootballScore.getFixtures()[position].getHomeTeamName());
        holder.mTextViewSecondTeam
                .setText(mFootballScore.getFixtures()[position].getAwayTeamName());
        holder.mTextViewGoalsFirstTeam
                .setText(getGoalsFirstTeam(mFootballScore, position));
        holder.mTextViewGoalsSecondTeam
                .setText(getGoalsSecondTeam(mFootballScore, position));
        holder.mCardView.setTag(position);
    }

    private String getGoalsSecondTeam(FootballScore footballScore, int position) {
        int result = 0;
        try {
            result = Integer.parseInt(footballScore.getFixtures()[position]
                    .getFootbollResult().getGoalsHomeTeam())
                    + Integer.parseInt(footballScore.getFixtures()[position]
                    .getFootbollResult().getResultHalfTime().getGoalsHomeTeam());
        } catch (NumberFormatException e){
            System.out.println("Неверный формат строки!");
        }

        return Integer.toString(result);
    }

    private String getGoalsFirstTeam(FootballScore footballScore, int position) {
        int result = 0;
        try {
            result = Integer.parseInt(footballScore.getFixtures()[position]
                    .getFootbollResult().getGoalsAwayTeam())
                    + Integer.parseInt(footballScore.getFixtures()[position]
                    .getFootbollResult().getResultHalfTime().getGoalsAwayTeam());
        } catch (NumberFormatException e){
            System.out.println("Неверный формат строки!");
        }
        return Integer.toString(result);
    }

    @Override
    public int getItemCount() {
        return mFootballScore.getFixtures().length;
    }
}
