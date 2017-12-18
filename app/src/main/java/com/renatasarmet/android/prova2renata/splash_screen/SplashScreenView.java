package com.renatasarmet.android.prova2renata.splash_screen;

public interface SplashScreenView {
    void showLoading();
    void hideLoading();

    void showMessage(String msg);

    void openActions(String jsonActions);

    void openActions();
}
