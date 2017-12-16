package com.renatasarmet.android.prova2renata.Actions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder> {

    private Context context;
    private List<ActionEntity> actionsList;
    OnRecyclerViewSelected onRecyclerViewSelected;

    //Construtor que recebe a lista
    ActionsAdapter(List<ActionEntity> actionsList) {
        this.actionsList = actionsList;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ActionEntity movieEntity = actionsList.get(position);
        holder.txActionName.setText(movieEntity.getName());
        Picasso.with(context)
                .load(movieEntity.getImageURL())
                .centerCrop()
                .fit()
                .into(holder.imgBackgroud);
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return actionsList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tx_action_name)
        TextView txActionName;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }

        //seta o clique longo
        @OnLongClick(R.id.container)
        boolean onLongItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onLongClick(view, getAdapterPosition());

            return true;
        }
    }
    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}