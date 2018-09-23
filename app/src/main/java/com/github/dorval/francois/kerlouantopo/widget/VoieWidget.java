package com.github.dorval.francois.kerlouantopo.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.dorval.francois.apitopo.model.ws.WsVoie;
import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;


public class VoieWidget extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView secteur;
    private final TextView cotation;
    //private final View hseparateur;
    private Voie voie;

    public VoieWidget(LinearLayout v) {

        super(v);
        secteur = (TextView) v.findViewById(R.id.secteur);
        cotation = (TextView) v.findViewById(R.id.cotation);
       // hseparateur= (View) v.findViewById(R.id.hseparateur);
        View root = v.findViewById(R.id.root);
        root.setOnClickListener(this);


    }

    public void setvoie(Voie voie, Voie voiePrecedante, Voie voieSuivante) {
        this.voie = voie;
        secteur.setText(voie.getSecteur());
        if (voie.getCotation()!=null){
            cotation.setText(voie.getCotation().getLabel());
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
