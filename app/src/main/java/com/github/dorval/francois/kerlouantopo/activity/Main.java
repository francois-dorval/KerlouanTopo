package com.github.dorval.francois.kerlouantopo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;


import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import com.github.dorval.francois.kerlouantopo.R;
import com.github.dorval.francois.kerlouantopo.util.OnSwipeTouchListener;

public class Main extends AppCompatActivity implements OnPageChangeListener, OnPageErrorListener {

    private static final int PAGE_NUMBER = 96;

    private int indexPage = 1;

    private PDFView pDFView;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        Intent i = getIntent();

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
            }
        }


        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pDFView = (PDFView) findViewById(R.id.pdfView);
       displayCurrentPage();

        pDFView.setOnTouchListener(new OnSwipeTouchListener(Main.this){
            public void onSwipeTop() {
                //Toast.makeText(Main.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                //Toast.makeText(Main.this, "right", Toast.LENGTH_SHORT).show();
                goLeft();

            }
            public void onSwipeLeft() {
                //Toast.makeText(Main.this, "left", Toast.LENGTH_SHORT).show();
                goRight();
            }
            public void onSwipeBottom() {
                //Toast.makeText(Main.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void goRight() {
        if (indexPage<PAGE_NUMBER){
            indexPage++;
        }
        displayCurrentPage();

    }

    private void goLeft() {
        if (indexPage>1){
            indexPage--;
        }
        displayCurrentPage();

    }


    private void displayCurrentPage() {


        String res =""+String.format("%02d.pdf", indexPage);
        Toast.makeText(Main.this, "page "+indexPage, Toast.LENGTH_SHORT).show();


        pDFView.fromAsset(res)
                .onPageChange(this)
                .enableAnnotationRendering(true)

                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .load();
        changeTitle();
    }

    private void setCustomTitle(CharSequence title){
        toolbar.setTitle(title);
    }

    private void changeTitle() {
        if (indexPage < 8){
            setCustomTitle(getResources().getText(R.string.app_name));

        }else if(indexPage<18){
            setCustomTitle(getResources().getText(R.string.petit_paradis));

        }else if(indexPage<28){
            setCustomTitle(getResources().getText(R.string.bivouac));

        }else if(indexPage<76){
            setCustomTitle(getResources().getText(R.string.meneham));

        }else if(indexPage<81){
            setCustomTitle(getResources().getText(R.string.riviere));

        }else{
            setCustomTitle(getResources().getText(R.string.cremiou));
        }


    }








    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}
