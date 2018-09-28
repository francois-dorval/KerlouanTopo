package com.github.dorval.francois.kerlouantopo.activity;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;


import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.fragment.PdfReaderFragment;
import com.github.dorval.francois.kerlouantopo.fragment.SecteurFragment;
import com.github.dorval.francois.kerlouantopo.model.Secteur;
import com.github.dorval.francois.kerlouantopo.util.OnSwipeTouchListener;

import org.apache.commons.lang3.StringUtils;

public class MainActivity extends AppCompatActivity {



    Toolbar toolbar;
    private String secteurPath;
    private SecteurFragment secteurFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initToolBar();

        FragmentManager fm = getSupportFragmentManager();
        PdfReaderFragment pdfReaderFragment = (PdfReaderFragment)fm.findFragmentById(R.id.pdf_reader_fragment);
        secteurFragment = (SecteurFragment)fm.findFragmentById(R.id.secteur_fragment);

        Intent i = getIntent();
        int indexPage=-1;
        MenuActivity.MenuElement selectedMenu = (MenuActivity.MenuElement) i.getSerializableExtra(MenuActivity.MENU_SELECTED);
        if (selectedMenu!=null){
            switch (selectedMenu){
                case TOUT:
                    indexPage = 1;
                    break;
                case PARADIS:
                    indexPage = 8;
                    break;
                case BIVOUAC:
                    indexPage = 18;
                    break;
                case MENEHAM:
                    indexPage = 28;
                    break;
                case RIVIERE:
                    indexPage = 76;
                    break;
                case CREMIOU:
                    indexPage = 81;
                    break;
                case NEIZVRAN:

            }
        }




        if (indexPage>-1){
            pdfReaderFragment.setCurrentPage(indexPage);
            pdfReaderFragment.displayCurrentPage();
            fm.beginTransaction()
                    //.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(pdfReaderFragment)
                    .hide(secteurFragment)
                    .commit();
        }else{
            fm.beginTransaction()
                    //.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(secteurFragment)
                    .hide(pdfReaderFragment)
                    .commit();
            secteurPath = Secteur.ID.NEIZVRAN.toString();
            secteurFragment.updateSecteurData(secteurPath);
            setCustomTitle(secteurFragment.getSecteurName());
        }

    }


    /**
     *
     */
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
    }

    /**
     * titre
     */
    public void setCustomTitle(CharSequence title){
        if (toolbar!=null && StringUtils.isNotEmpty(title)){
            toolbar.setTitle(title);
        }


    }


    public void goToSecteur(Secteur.ID id) {
        secteurPath +="/"+id.toString();
        secteurFragment.updateSecteurData(secteurPath);
        getSupportFragmentManager().beginTransaction().detach(secteurFragment).attach(secteurFragment).commit();

        setCustomTitle(secteurFragment.getSecteurName());
    }
}
