package com.github.dorval.francois.kerlouantopo.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;

import org.apache.commons.lang3.StringUtils;


public class VoieWidget extends RecyclerView.ViewHolder implements View.OnClickListener {


    private final TextView cotation;
    private final TextView nom;
    private final TextView id;
    private final TextView commentaire;
    private final ImageView camera;


    public VoieWidget(LinearLayout v) {

        super(v);
        id = (TextView) v.findViewById(R.id.id);
        nom = (TextView) v.findViewById(R.id.nom);
        cotation = (TextView) v.findViewById(R.id.cotation);
        commentaire = (TextView) v.findViewById(R.id.commentaire);
        camera = (ImageView) v.findViewById(R.id.camera);

        View root = v.findViewById(R.id.root);
        root.setOnClickListener(this);


    }

    public void setvoie(Voie voie) {

        id.setText(voie.getId().toString());

        nom.setText(voie.getNom());

        if (StringUtils.isNotEmpty(voie.getNom())){
            commentaire.setText(voie.getNom());
        }

        if (voie.getCotation()!=null){
            cotation.setText(voie.getCotation().getLabel());
        }


        if (StringUtils.isNotEmpty(voie.getCommentaire())){
            commentaire.setText(voie.getCommentaire());
        }



    }


    @Override
    public void onClick(View view) {
        Context context = view.getContext();


        //Intent intent = new Intent(context , DetailVoieActivity.class);
        //intent.putExtra(Voie.VOIE, voie);

        //context.startActivity(intent);
    }
}
