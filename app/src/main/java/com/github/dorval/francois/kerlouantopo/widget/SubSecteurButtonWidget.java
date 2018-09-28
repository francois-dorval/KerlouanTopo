package com.github.dorval.francois.kerlouantopo.widget;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.model.SubSecteur;
import com.github.dorval.francois.kerlouantopo.model.Voie;
import com.github.dorval.francois.kerlouantopo.util.ImageFromAsset;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;


public class SubSecteurButtonWidget extends RecyclerView.ViewHolder {



    private final Button button;



    public SubSecteurButtonWidget(LinearLayout v) {

        super(v);
        button = (Button) v.findViewById(R.id.btn);
    }

    public void setSubSecteur(SubSecteurButtonWidget holder, SubSecteur subSecteur) {
        button.setText(subSecteur.getNom().toString());
    }



    public void setOnClickListener(View.OnClickListener onClickListener) {
        button.setOnClickListener(onClickListener);

    }
}
