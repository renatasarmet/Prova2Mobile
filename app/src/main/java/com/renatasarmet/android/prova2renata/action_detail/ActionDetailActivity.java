package com.renatasarmet.android.prova2renata.action_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        //insere opção Up Action na ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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
