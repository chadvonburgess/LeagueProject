package compl3x.databind.League.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import compl3x.databind.League.Model.League;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;

/**
 * Created by chad on 1/30/2017.
 */

public class LeagueFactory {

    private static List<League> leagues;

    public static Single<List<League>> create(){
        return Single.fromCallable(new Callable<List<League>>() {
            @Override
            public List<League> call() throws Exception {
                return objectList();
            }
        });
    }

    public static Observable<List<League>> newObservable(){ // this will give an observable but wont give you a stream. need to really inherit from an ObservableSource
        return Observable.defer(new Callable<ObservableSource<? extends List<League>>>() {
            @Override
            public ObservableSource<? extends List<League>> call() throws Exception {
                return Observable.just(objectList());
            }
        });
    }

    private static List<League> objectList() {
        if(leagues == null) {
            leagues = new ArrayList<>(10);
            for (int x = 0; x < 10; x++) {
                leagues.add(new League(x));
            }
        }
        return leagues;
    }
}
