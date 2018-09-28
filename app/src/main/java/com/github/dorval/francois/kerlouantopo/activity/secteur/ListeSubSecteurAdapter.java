package com.github.dorval.francois.kerlouantopo.activity.secteur;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.SubSecteur;
import com.github.dorval.francois.kerlouantopo.model.Voie;
import com.github.dorval.francois.kerlouantopo.widget.SubSecteurButtonWidget;
import com.github.dorval.francois.kerlouantopo.widget.VoieWidget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListeSubSecteurAdapter extends RecyclerView.Adapter<SubSecteurButtonWidget> {
    private final SubSecteurButtonClickListener listener;
    private List<SubSecteur> dataSet;



    // Provide a suitable constructor (depends on the kind of dataset)
    public ListeSubSecteurAdapter(List<SubSecteur> myDataset, SubSecteurButtonClickListener listener) {
        if (myDataset!=null){
            dataSet = myDataset;
        }else{
            dataSet = new ArrayList<>();
        }
        this.listener = listener;


    }

    // Create new views (invoked by the layout manager)
    @Override
    public SubSecteurButtonWidget onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_subsecteur_button, parent, false);

        final SubSecteurButtonWidget sb = new SubSecteurButtonWidget(v);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, sb.getLayoutPosition());
            }
        });        return sb;
    }

    @Override
    public void onBindViewHolder(@NonNull SubSecteurButtonWidget subSecteurButtonWidget, int i) {
        subSecteurButtonWidget.setSubSecteur(subSecteurButtonWidget, dataSet.get(i));

    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
