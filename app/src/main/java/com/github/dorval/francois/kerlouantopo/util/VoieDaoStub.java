package com.github.dorval.francois.kerlouantopo.util;

import com.github.dorval.francois.kerlouantopo.model.voie.Cotation;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;


public class VoieDaoStub  {




    public VoieDaoStub() {

    }


    public static List<Voie> getVoies() {
        List<Voie> res = new ArrayList<>();
        res.add(getVoie1());
        res.add(getVoie2());
        res.add(getVoie3());
        res.add(getVoie4());
        res.add(getVoie5());
        res.add(getVoie6());
        res.add(getVoie7());
        res.add(getVoie8());
        res.add(getVoie9());
        res.add(getVoie10());
        res.add(getVoie11());
        res.add(getVoie12());
        res.add(getVoie13());
        res.add(getVoie14());
        res.add(getVoie15());
        res.add(getVoie16());
        res.add(getVoie17());
        res.add(getVoie18());
        res.add(getVoie19());
        res.add(getVoie20());

        Long i=1L;
        for(Voie voie:res){
            Lorem lorem = LoremIpsum.getInstance();
            voie.setId(i);
            voie.setCommentaire(lorem.getWords(0,20));
            voie.setNom(lorem.getWords(1,3));
            i++;
        }
        return res;
    }

    
    

    public static Voie getVoie1(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_A);
        return voie;
    }

    public static Voie getVoie2(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C);
        return voie;
    }

    public static Voie getVoie3(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);
        return voie;
    }

    public static Voie getVoie4(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }


    public static Voie getVoie5(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }

    public static Voie getVoie6(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }

    public static Voie getVoie7(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }

    public static Voie getVoie8(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }

    public static Voie getVoie9(){
        Voie voie = new Voie();

        return voie;
    }

    public static Voie getVoie10(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.CINQ_C_PLUS);

        return voie;
    }

    public static Voie getVoie11(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.SIX_A);

        return voie;
    }

    public static Voie getVoie12(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.SIX_A);
        return voie;
    }

    public static Voie getVoie13(){
        Voie voie = new Voie();

        return voie;
    }
    public static Voie getVoie14(){
        Voie voie = new Voie();

        return voie;
    }
    public static Voie getVoie15(){
        Voie voie = new Voie();
        voie.setCotation(Cotation.SIX_A);
        return voie;
    }
    public static Voie getVoie16(){
        Voie voie = new Voie();

        return voie;
    }
    public static Voie getVoie17(){
        Voie voie = new Voie();

        return voie;
    }
    public static Voie getVoie18(){
        Voie voie = new Voie();

        return voie;
    }

    public static Voie getVoie19(){
        Voie voie = new Voie();

        return voie;
    }

    public static Voie getVoie20(){
        Voie voie = new Voie();

        return voie;
    }



}
