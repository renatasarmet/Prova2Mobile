package com.renatasarmet.android.prova2renata.action_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionDetailActivity extends AppCompatActivity implements ActionDetailView {

    ActionDetailPresenter actionDetailPresenter;
    ActionEntity actionDetailEntity;

    @BindView(R.id.image_view_header)
    ImageView imgHeader;

    @BindView(R.id.text_view_description)
    TextView tvDescription;

    @BindView(R.id.text_view_site)
    TextView tvSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_detail);
        ButterKnife.bind(this);

        actionDetailEntity = new ActionEntity();

        Intent intent = getIntent();
        long id = intent.getLongExtra("Id",0);
        String name = intent.getStringExtra("Name");
        String image = intent.getStringExtra("Image");
        String description = intent.getStringExtra("Description");
        String site = intent.getStringExtra("Site");


        actionDetailPresenter = new ActionDetailPresenter(this);
        actionDetailPresenter.getActionDetail(id,name,image,description,site);

    }

    public void showDetails(ActionEntity actionDetailEntity) {
        Picasso.with(this)
                .load(actionDetailEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        tvDescription.setText(actionDetailEntity.getDescription());
        tvSite.setText(actionDetailEntity.getSite());
        setTitle(actionDetailEntity.getName());
    }
}
