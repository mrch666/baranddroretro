package ru.specinstrument.instrumentstore.modelgoods.ui.search;

import ru.specinstrument.instrumentstore.modelgoods.models.ModelgoodsList;

/**
 * Created by anujgupta on 27/12/17.
 */

public interface SearchViewInterface {

    void showToast(String str);
    void displayResult(ModelgoodsList modelgoodsList);
    void displayError(String s);
    void showProgressBar();
    void hideProgressBar();
}
