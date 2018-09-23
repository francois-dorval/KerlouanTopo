package com.github.dorval.francois.kerlouantopo.activity.secteur;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;
import com.github.dorval.francois.kerlouantopo.widget.VoieWidget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListeVoieAdapter extends RecyclerView.Adapter<VoieWidget> {
    private List<Voie> dataSet;



    // Provide a suitable constructor (depends on the kind of dataset)
    public ListeVoieAdapter(List<Voie> myDataset) {
        if (myDataset!=null){
            Collections.sort(myDataset);
            dataSet = myDataset;
        }else{
            dataSet = new ArrayList<>();
        }

    }

    // Create new views (invoked by the layout manager)
    @Override
    public VoieWidget onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_voie, parent, false);

        VoieWidget vh = new VoieWidget(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(VoieWidget holder, int position) {

        Voie voieSuivante = null;
        Voie voiePrecendante = null;
        if (position>0){
            voiePrecendante = dataSet.get(position-1);
        }

        if (dataSet.size()>position+1){
            voieSuivante = dataSet.get(position+1);
        }
        holder.setvoie(dataSet.get(position), voiePrecendante, voieSuivante);



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
