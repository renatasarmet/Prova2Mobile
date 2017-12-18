package com.renatasarmet.android.prova2renata.Actions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);

        actionsPresenter = new ActionsPresenter(this);
        actionsPresenter.updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void updateList(final List<ActionEntity> actionsList) {
        // Seta o Adapter
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent openDetailActivity = new Intent(ActionsActivity.this, ActionDetailActivity.class);
                openDetailActivity.putExtra("Id", actionsList.get(position).getId());
                openDetailActivity.putExtra("Name", actionsList.get(position).getName());
                openDetailActivity.putExtra("Image", actionsList.get(position).getImage());
                openDetailActivity.putExtra("Description", actionsList.get(position).getDescription());
                openDetailActivity.putExtra("Site", actionsList.get(position).getSite());

                startActivity(openDetailActivity);
            }
        });

        rvActions.setAdapter(actionsAdapter);

        // Criacao de gerenciador de layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvActions.setLayoutManager(layoutManager);

        //inserindo separador de itens
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvActions.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
