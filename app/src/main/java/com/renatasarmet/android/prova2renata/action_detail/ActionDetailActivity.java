package com.renatasarmet.android.prova2renata.action_detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.renatasarmet.android.prova2renata.R;
import com.renatasarmet.android.prova2renata.Entity.ActionDetailEntity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionDetailActivity extends AppCompatActivity implements ActionDetailView {

    ActionDetailPresenter actionDetailPresenter;

    @BindView(R.id.image_view_header)
    ImageView imgHeader;

    @BindView(R.id.text_view_description)
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_detail);
        //insere opção de voltar na actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ButterKnife.bind(this);

        actionDetailPresenter = new ActionDetailPresenter(this);
        long idActionSelected = getIntent().getLongExtra("ACTION_ID", 0);
        actionDetailPresenter.getActionDetail(idActionSelected);

    }

    @Override
    public void showDetails(ActionDetailEntity actionDetailEntity) {
        Picasso.with(this)
                .load(actionDetailEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        tvDescription.setText(actionDetailEntity.getDescription());
        setTitle(actionDetailEntity.getName());
    }

    @Override
    public void showMessage(String msg) {

    }
}
