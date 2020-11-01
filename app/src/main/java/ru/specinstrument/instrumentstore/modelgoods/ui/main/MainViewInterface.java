package ru.specinstrument.instrumentstore.modelgoods.ui.main;

import java.util.List;

import ru.specinstrument.instrumentstore.modelgoods.models.Modelgoods;

/**
 * Created by anujgupta on 26/12/17.
 */

public interface MainViewInterface {

    void showToast(String s);
    void showProgressBar();
    void hideProgressBar();
    void displayModelgoods(List<Modelgoods> modelgoodsList);
    void displayError(String s);
}
