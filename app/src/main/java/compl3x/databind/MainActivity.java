package compl3x.databind;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import compl3x.databind.League.Data.LeagueFactory;
import compl3x.databind.League.Model.League;
import compl3x.databind.League.View.LeagueAdapter;
import compl3x.databind.databinding.MainActivityBinding;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private LeagueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.leagueList.setLayoutManager(layoutManager);
        adapter = new LeagueAdapter();
        binding.leagueList.setAdapter(adapter);
        /*
        this could probably be done better, this is just trying out singles, everyone can use observables they are boring.
         */
        LeagueFactory.create().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<League>>() {
            @Override
            public void accept(List<League> leagues) throws Exception {
                adapter.setItems(leagues);
            }
        });
        //continue

    }
}
