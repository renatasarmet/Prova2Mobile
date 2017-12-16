package com.renatasarmet.android.prova2renata.Actions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsActivity extends AppCompatActivity implements ActionsView {

    @BindView(R.id.rv_actions)
    RecyclerView rvActions;

    ActionsPresenter actionsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);

        actionsPresenter = new ActionsPresenter(this);

    }

    @Override
    public void updateList(List<ActionEntity> actionsList) {
        // Seta o Adapter
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ActionsActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(ActionsActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();

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

    @Override
    public void setList(ActionListEntity actionListEntity) {
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionListEntity.getActions());

        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ActionsActivity.this, "Clique rápido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(ActionsActivity.this, "Clique longo", Toast.LENGTH_SHORT).show();
            }
        });

        rvActions.setAdapter(actionsAdapter);
    }
}
