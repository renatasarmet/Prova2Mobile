package com.renatasarmet.android.prova2renata.splash_screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.renatasarmet.android.prova2renata.Actions.ActionsActivity;
import com.renatasarmet.android.prova2renata.R;

import butterknife.BindView;

public class SplashScreenActivity  extends AppCompatActivity implements SplashScreenView{

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    SplashScreenPresenter splashScreenPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences preferences = getSharedPreferences(getString(R.string.actions), MODE_PRIVATE);
        String jsonActions = preferences.getString(getString(R.string.action_entity_json), null);

        splashScreenPresenter = new SplashScreenPresenter(this);
        splashScreenPresenter.openApp(jsonActions);

    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openActions(String jsonActions) {
        Intent abreActionsActivityOffline = new Intent(SplashScreenActivity.this, ActionsActivity.class);
        abreActionsActivityOffline.putExtra("json_actions", jsonActions);
        startActivity(abreActionsActivityOffline);
        finish();
    }

    @Override
    public void openActions() {
        Intent abrirActions = new Intent(SplashScreenActivity.this, ActionsActivity.class);
        startActivity(abrirActions);
        finish();
    }

}
