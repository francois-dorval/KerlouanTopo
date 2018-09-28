package com.github.dorval.francois.kerlouantopo.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.activity.MainActivity;
import com.github.dorval.francois.kerlouantopo.activity.secteur.ListeSubSecteurAdapter;
import com.github.dorval.francois.kerlouantopo.activity.secteur.ListeVoieAdapter;
import com.github.dorval.francois.kerlouantopo.activity.secteur.SubSecteurButtonClickListener;
import com.github.dorval.francois.kerlouantopo.dao.SecteurDao;
import com.github.dorval.francois.kerlouantopo.model.Secteur;
import com.github.dorval.francois.kerlouantopo.model.SubSecteur;
import com.github.dorval.francois.kerlouantopo.model.Voie;
import com.github.dorval.francois.kerlouantopo.util.ErrorPopup;
import com.github.dorval.francois.kerlouantopo.util.ImageFromAsset;

import java.io.IOException;
import java.util.List;

public class SecteurFragment extends Fragment {


    private RecyclerView recycler_view_voies;

    private RecyclerView recycler_view_subsecteurs;

    SecteurDao secteurDao = new SecteurDao();

    private Secteur secteur;

    ImageView img;

    TextView commentaire;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);



        View view = inflater.inflate(R.layout.fragment_secteur, container, false);

        img = (ImageView)view.findViewById(R.id.img);
        commentaire = (TextView)view.findViewById(R.id.commentaire);

        recycler_view_voies = (RecyclerView) view.findViewById(R.id.recycler_view_voies);
        recycler_view_voies.setHasFixedSize(true);

        recycler_view_subsecteurs = (RecyclerView) view.findViewById(R.id.recycler_view_subsecteurs);
        recycler_view_subsecteurs.setHasFixedSize(true);

        recycler_view_voies.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        recycler_view_subsecteurs.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });




        return view;
    }



    public void updateSecteurData(String secteurPath){
        try {
            secteur = secteurDao.getSecteur(this.getActivity(), secteurPath);

            commentaire.setText(secteur.getDescription1());

            try {
                Bitmap bitmap = ImageFromAsset.getBitmapFromAssets(img.getContext().getAssets(), secteur.getMap());
                img.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();

            }

            //List<Voie> voies = VoieDaoStub.getVoies();
            List<Voie> voies = secteur.getVoies();
            recycler_view_voies.setAdapter(new ListeVoieAdapter(voies));

            final List<SubSecteur> subSecteurs = secteur.getSubsecteurs();
            recycler_view_subsecteurs.setAdapter(new ListeSubSecteurAdapter(subSecteurs,
                    new SubSecteurButtonClickListener() {
                        @Override
                        public void onItemClick(View v, int position) {

                            Secteur.ID id = subSecteurs.get(position).getId();
                            ((MainActivity)getActivity()).goToSecteur(id);


                            // do what ever you want to do with it
                        }}));

            //setCustomTitle(secteur.getNom());
        } catch (Exception e) {
            e.printStackTrace();
            ErrorPopup.show(this.getContext(), "Erreur récupération données secteur");
        }
    }

    /**
     *
     * @return
     */
    public CharSequence getSecteurName() {
        if (secteur!=null){
            return secteur.getNom();
        }
        return null;
    }
}
