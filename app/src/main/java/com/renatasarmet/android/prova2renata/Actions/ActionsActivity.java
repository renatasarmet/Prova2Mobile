package com.renatasarmet.android.prova2renata.Actions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.R;

import java.io.FileNotFoundException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsActivity extends AppCompatActivity implements ActionsView {

    @BindView(R.id.rv_actions)
    RecyclerView rvActions;

    ActionsPresenter actionsPresenter;

    //private static final String ENDPOINT = "https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais.json";

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);

        actionsPresenter = new ActionsPresenter(this);
        actionsPresenter.updateList();
    }


    @Override
    public void updateList(List<ActionEntity> actionsList) {
        // Seta o Adapter
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ActionsActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }
        });

        rvActions.setAdapter(actionsAdapter);

        // Criacao de gerenciador de layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvActions.setLayoutManager(layoutManager);

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
