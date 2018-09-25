package com.github.dorval.francois.kerlouantopo.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;
import com.github.dorval.francois.kerlouantopo.util.ImageFromAsset;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;


public class VoieWidget extends RecyclerView.ViewHolder implements View.OnClickListener {


    private final TextView cotation;
    private final TextView nom;
    private final TextView id;
    private final TextView commentaire;
    private final ImageView camera;
    private final ImageView photo;

    private boolean photoPresent = false;

    public VoieWidget(LinearLayout v) {

        super(v);
        id = (TextView) v.findViewById(R.id.id);
        nom = (TextView) v.findViewById(R.id.nom);
        cotation = (TextView) v.findViewById(R.id.cotation);
        commentaire = (TextView) v.findViewById(R.id.commentaire);
        camera = (ImageView) v.findViewById(R.id.camera);
        photo = (ImageView) v.findViewById(R.id.photo);

        View root = v.findViewById(R.id.root);
        root.setOnClickListener(this);
    }

    public void setVoie(VoieWidget holder, Voie voie) {

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

        if (StringUtils.isNotEmpty(voie.getPhoto())){
            photoPresent = true;

            try {
                Bitmap bitmap = ImageFromAsset.getBitmapFromAssets(holder.itemView.getContext().getAssets(), voie.getPhoto());
                photo.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
                camera.setVisibility(View.GONE);
                photoPresent = false;
            }

            camera.setVisibility(View.VISIBLE);
        }else{
            photoPresent = false;
            camera.setVisibility(View.GONE);
            photo.setVisibility(View.GONE);
        }



    }


    @Override
    public void onClick(View view) {
        if (photoPresent){
            if (View.GONE == photo.getVisibility()){
                photo.setVisibility(View.VISIBLE);
            }else{
                photo.setVisibility(View.GONE);
            }
        }
    }
}
