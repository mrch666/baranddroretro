package ru.specinstrument.instrumentstore.modelgoods;

import android.app.Application;

import ru.specinstrument.instrumentstore.modelgoods.di.components.ApplicationComponent;
import ru.specinstrument.instrumentstore.modelgoods.di.components.DaggerApplicationComponent;
import ru.specinstrument.instrumentstore.modelgoods.di.modules.ApplicationModule;


/**
 * Created by anujgupta on 22/01/18.
 */

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

      public MyApplication(){

      }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                                .builder()
                                .applicationModule(new ApplicationModule(this))
                                .build();

    }

    public ApplicationComponent getApplicationComponent(){
          return applicationComponent;
      }

}
