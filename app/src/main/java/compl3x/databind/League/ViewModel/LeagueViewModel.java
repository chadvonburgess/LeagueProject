package compl3x.databind.League.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import compl3x.databind.League.Model.League;
import compl3x.databind.R;

/**
 * Created by chad on 1/31/2017.
 * honestly only makes sense that this extends base observable otherwise this view is exposing directly the data in the model which isn't that kind of what we are
 * trying to avoid here ?
 */

public class LeagueViewModel extends BaseObservable {

    private League league;
    private Context context;

    public LeagueViewModel(League league, Context context) {
        this.league = league;
        this.context = context;
    }

    @Bindable
    public String getDescriptor() {
        return league.getDescriptor();
    }

    public void setDescriptor(String descriptor) {
        league.setDescriptor(descriptor);
        notifyPropertyChanged(BR.descriptor);
    }

    public int getBackgroundColor() {
        return ContextCompat.getColor(context, league.getActive() ? R.color.white : R.color.grey);
    }

    public int getSignupAvailable() {
        return league.getSignupAvailable() ? View.VISIBLE : View.GONE;
    }

    public String getLeaderKey() {
        return league.getLeaderKey();
    }

    public int getShowLeaderKey() {
        return !TextUtils.isEmpty(league.getLeaderKey()) ? View.VISIBLE : View.GONE;
    }

    @Bindable
    public String getTitle() {
        return league.getTitle();
    }

    public void setTitle(String title) {
        league.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public View.OnClickListener onSignupClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle(context.getString(R.string.card_signup_clicktemp));
            }
        };
    }

    public View.OnClickListener onItemClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        };
    }


}
