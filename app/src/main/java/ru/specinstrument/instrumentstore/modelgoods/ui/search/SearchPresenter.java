package ru.specinstrument.instrumentstore.modelgoods.ui.search;

import android.support.v7.widget.SearchView;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ru.specinstrument.instrumentstore.modelgoods.models.ModelgoodsList;
import ru.specinstrument.instrumentstore.modelgoods.network.NetworkClient;
import ru.specinstrument.instrumentstore.modelgoods.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by anujgupta on 27/12/17.
 */

public class SearchPresenter implements SearchPresenterInterface {

    private String TAG = "SearchPresenter";
    SearchViewInterface searchviewInterface;
    public SearchPresenter(SearchViewInterface searchViewInterface) {
        this.searchviewInterface = searchViewInterface;
    }


    @Override
    public void getResultsBasedOnQuery(SearchView searchView) {

        getObservableQuery(searchView)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        if(s.equals("")){
                            return false;
                        }else{
                            return true;
                        }
                    }
                })
                .debounce(2, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<ModelgoodsList>>() {
                    @Override
                    public Observable<ModelgoodsList> apply(@NonNull String s) throws Exception {
                        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                                .getModelgoodsBasedOnQuery(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver());


    }

    private Observable<String> getObservableQuery(SearchView searchView){

        final PublishSubject<String> publishSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                publishSubject.onNext(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                publishSubject.onNext(newText);
                return true;
            }
        });

        return publishSubject;
    }

    public DisposableObserver<ModelgoodsList> getObserver(){
        return new DisposableObserver<ModelgoodsList>() {

            @Override
            public void onNext(@NonNull ModelgoodsList ModelgoodsList) {

                searchviewInterface.displayResult(ModelgoodsList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                searchviewInterface.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
