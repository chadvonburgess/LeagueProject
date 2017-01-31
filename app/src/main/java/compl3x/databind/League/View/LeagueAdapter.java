package compl3x.databind.League.View;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import compl3x.databind.League.Model.League;
import compl3x.databind.League.ViewModel.LeagueViewModel;
import compl3x.databind.R;
import compl3x.databind.databinding.ItemLeagueBinding;

/**
 * Created by chad on 1/31/2017.
 */

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {

    List<League> leagues = new ArrayList<>();

    @Override
    public LeagueAdapter.LeagueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemLeagueBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_league,parent,false);
        return new LeagueViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(LeagueAdapter.LeagueViewHolder holder, int position) {
            holder.bindLeague(leagues.get(position));
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    public void setItems(List<League> leaguesIn){
        if(leaguesIn!= null) {
            this.leagues.addAll(leaguesIn);
            notifyDataSetChanged();
        }
    }


    public static class LeagueViewHolder extends RecyclerView.ViewHolder {
        ItemLeagueBinding itemLeagueBinding;
        public LeagueViewHolder(ItemLeagueBinding itemView) {
            super(itemView.cardView);
            itemLeagueBinding = itemView;
        }

        public void bindLeague(League league){
            itemLeagueBinding.setLeague(new LeagueViewModel(league,itemView.getContext()));
        }
    }
}
