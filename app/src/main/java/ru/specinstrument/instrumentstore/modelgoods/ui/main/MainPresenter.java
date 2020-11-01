package ru.specinstrument.instrumentstore.modelgoods.ui.main;


import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ru.specinstrument.instrumentstore.modelgoods.models.Modelgoods;
import ru.specinstrument.instrumentstore.modelgoods.models.ModelgoodsList;
import ru.specinstrument.instrumentstore.modelgoods.network.NetworkClient;
import ru.specinstrument.instrumentstore.modelgoods.network.NetworkInterface;

/**
 * Created by anujgupta on 26/12/17.
 */

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mvi;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getMovies() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<List<Modelgoods>> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                            .getModelgoods()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<List<Modelgoods>>  getObserver(){
        return new DisposableObserver<List<Modelgoods>> () {



            @Override
            public void onNext(List<Modelgoods> modelgoodsList) {
                mvi.displayModelgoods(modelgoodsList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                mvi.hideProgressBar();
            }
        };
    }
}
