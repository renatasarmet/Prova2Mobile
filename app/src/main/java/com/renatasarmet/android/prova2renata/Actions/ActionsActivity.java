package com.renatasarmet.android.prova2renata.Actions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.renatasarmet.android.prova2renata.action_detail.ActionDetailActivity;
import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
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
        actionsPresenter.updateList();
    }


    @Override
    public void updateList(List<ActionEntity> actionsList) {
        // Seta o Adapter
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent openDetailActivity = new Intent(ActionsActivity.this, ActionDetailActivity.class);
                openDetailActivity.putExtra("ACTION_ID", actionsPresenter.getActionId(position));
                startActivity(openDetailActivity);
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
