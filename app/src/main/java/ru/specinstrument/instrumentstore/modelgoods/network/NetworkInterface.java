package ru.specinstrument.instrumentstore.modelgoods.network;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.specinstrument.instrumentstore.modelgoods.models.Modelgoods;
import ru.specinstrument.instrumentstore.modelgoods.models.ModelgoodsList;

/**
 * Created by anujgupta on 26/12/17.
 */

public interface NetworkInterface {

    @GET("groupgoods")
    Observable<List<Modelgoods>> getModelgoods();

    @GET("/modelgoods/bycode/{query}")
    Observable<ModelgoodsList> getModelgoodsBasedOnQuery(@Path("query") String q);
}
