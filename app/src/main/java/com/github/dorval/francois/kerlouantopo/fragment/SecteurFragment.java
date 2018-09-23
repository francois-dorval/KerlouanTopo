package com.github.dorval.francois.kerlouantopo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.activity.MainActivity;
import com.github.dorval.francois.kerlouantopo.activity.secteur.ListeVoieAdapter;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;
import com.github.dorval.francois.kerlouantopo.util.VoieDaoStub;

import java.util.ArrayList;
import java.util.List;

public class SecteurFragment extends Fragment {


    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_secteur, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        List<Voie> voies = VoieDaoStub.getVoies();
        recyclerView.setAdapter(new ListeVoieAdapter(voies));
        return view;
    }



    private void setCustomTitle(CharSequence text) {
        ((MainActivity)getActivity()).setCustomTitle(text);
    }

}
